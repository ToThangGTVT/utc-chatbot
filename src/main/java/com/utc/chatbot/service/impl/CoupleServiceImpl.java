package com.utc.chatbot.service.impl;

import com.utc.chatbot.common.StringMessage;
import com.utc.chatbot.entity.database.Couple;
import com.utc.chatbot.entity.database.Customer;
import com.utc.chatbot.exception.CustomerNotFoundException;
import com.utc.chatbot.repository.CoupleRepository;
import com.utc.chatbot.repository.CustomerRepository;
import com.utc.chatbot.service.CoupleService;
import com.utc.chatbot.service.CustomerService;
import com.utc.chatbot.utils.CallApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class CoupleServiceImpl implements CoupleService {

    @Autowired
    CacheManager cacheManager;

    private final CoupleRepository coupleRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    public CoupleServiceImpl(CoupleRepository coupleRepository, CustomerRepository customerRepository) {
        this.coupleRepository = coupleRepository;
        this.customerRepository = customerRepository;
    }

    @Override
//    @Transactional(rollbackOn = Exception.class)
    public void saveCouple(String idMess, Integer criteria) throws IOException {
        Customer customer = customerRepository.findByIdMessenger(idMess);
        if (customer == null) {
            customer = new Customer();
            customer.setIdMessenger(idMess);
        }

        if (criteria == 3) {

            // Kiểm tra có ai chờ hay ko là tìm ngẫu nhiên
            Couple couple = checkWaiting(3);
            if (couple != null && couple.getIdMessFirst() != null) {
                // Trường hợp tìm ngẫu nhiên
                if (couple.getCriteriaFirst() == 3 && couple.getCriteriaSecond() == null) {
                    saveInfoCoupleNotSameGender(idMess, customer, couple, 3);
                } else {
                    saveInfoToCoupleSameGender(idMess, criteria, customer);
                }
            } else {
                saveInfoToCoupleSameGender(idMess, criteria, customer);
            }
        }

        // Kiểm tra có ai chờ hay ko
        Couple couple = checkWaiting(null);

        // Nếu có người đang chờ (sẽ là người thứ nhất)
        if (couple != null && couple.getIdMessFirst() != null) {

            // Nếu người thứ nhất là nam và người mới đến là nữ
            // Thì lưu thông tin người thứ 2 lại
            // Và thông báo đã tìm thấy đối phương
            if (couple.getCriteriaFirst() == 1 && criteria == 2) {
                saveInfoCoupleNotSameGender(idMess, customer, couple, 2);
                isExistTrue(idMess);
            }

            // Trường hợp 2 người cùng tìm 1 giới
            if (couple.getCriteriaFirst() == 1 && criteria == 1) {
                saveInfoToCoupleSameGender(idMess, criteria, customer);
                isExistTrue(idMess);
            }

            // Nếu người thứ nhất là nữ và người mới đến là nam
            // Thì lưu thông tin người thứ 2 lại
            // Và thông báo đã tìm thấy đối phương
            if (couple.getCriteriaFirst() == 2 && criteria == 1) {
                saveInfoCoupleNotSameGender(idMess, customer, couple, 1);
                isExistTrue(idMess);
            }

            // Trường hợp 2 người cùng tìm 1 giới
            if (couple.getCriteriaFirst() == 2 && criteria == 2) {
                saveInfoToCoupleSameGender(idMess, criteria, customer);
                isExistTrue(idMess);
            }

            // Ngược lại nếu trc đó chưa có ai chờ
            // Lưu thông tin của người mới đến này lại
            // Và người mới đến này sẽ là người thứ nhất trong DB
            // Và thông báo đang tìm đối phương cho người này
        } else {
            saveInfoToCoupleSameGender(idMess, criteria, customer);
            isExistTrue(idMess);
        }
    }

    // Kiểm tra có ai chờ hay ko
    private Couple checkWaiting(Integer criteria) {
        if (criteria == null) {
            List<Couple> couples = coupleRepository.findAllByIdMessSecond(null);
            if (couples.size() == 0) return null;
            return couples.get(0);
        } else {
            return coupleRepository.findByCriteriaFirstAndCriteriaSecond(3, null);
        }
    }

    private void saveInfoCoupleNotSameGender(String idMess, Customer customer, Couple couple, int i) throws IOException {
        couple.setIdMessSecond(customer);
        couple.setCriteriaSecond(i);
        coupleRepository.save(couple);
        String idStrangers = customerService.findAnotherPartner(idMess).getIdMessenger();

//        isExistTrue(idMess);
//        isExistTrue(idStrangers);

        CallApi.sendNotify(idMess,
                StringMessage.NOTIFY_TITLE_GENERAL,
                StringMessage.NOTIFY_FOUNDED_STRANGER + idStrangers);
        CallApi.sendNotify(idStrangers,
                StringMessage.NOTIFY_TITLE_GENERAL,
                StringMessage.NOTIFY_FOUNDED_STRANGER + idMess);
    }

    private void saveInfoToCoupleSameGender(String idMess, Integer criteria, Customer customer) throws IOException {
        Couple coupleNew = new Couple();
        coupleNew.setIdMessFirst(customer);
        coupleNew.setCriteriaFirst(criteria);
        coupleRepository.save(coupleNew);
        CallApi.sendNotify(idMess, StringMessage.NOTIFY_TITLE_FOUNDING_STRANGER, StringMessage.NOTIFY_FOUNDING_STRANGER);
    }

    public void deleteCouple(String idMess) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByIdMessenger(idMess);
        Couple couple = coupleRepository.findByIdMessFirst(customer);
        if (couple != null) {
            coupleRepository.delete(couple);
        } else if ((couple = coupleRepository.findByIdMessSecond(customer)) != null) {
            coupleRepository.delete(couple);
        } else {
            throw new CustomerNotFoundException();
        }
    }

    public void isExistTrue(String idMess) {
        cacheManager.getCache(StringMessage.IS_EXIST_USER_CACHE).put(idMess, true);
    }

    // Tìm xem người này có đang chat với người nào đó ko
    @Override
    @Cacheable(cacheNames = StringMessage.IS_EXIST_USER_CACHE, key = "#idMess")
    public Boolean isExist(String idMess) {
        Customer customer = customerRepository.findByIdMessenger(idMess);
        if (customer == null) return Boolean.FALSE;
        if (coupleRepository.findByIdMessFirst(customer) != null |
                coupleRepository.findByIdMessSecond(customer) != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Couple> findAll() {
        return coupleRepository.findAll();
    }
}
