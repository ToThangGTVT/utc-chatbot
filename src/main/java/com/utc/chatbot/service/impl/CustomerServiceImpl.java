package com.utc.chatbot.service.impl;

import com.utc.chatbot.common.StringMessage;
import com.utc.chatbot.entity.database.Couple;
import com.utc.chatbot.entity.database.Customer;
import com.utc.chatbot.repository.CoupleRepository;
import com.utc.chatbot.repository.CustomerRepository;
import com.utc.chatbot.service.CustomerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CoupleRepository coupleRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CoupleRepository coupleRepository) {
        this.customerRepository = customerRepository;
        this.coupleRepository = coupleRepository;
    }

    @Override
    public void save(Customer customer) {
        String id = customer.getIdMessenger();
        Customer cusDb = customerRepository.findByIdMessenger(id);
        if(cusDb == null){
            customerRepository.save(customer);
        }
    }

    @Override
//    @Transactional(rollbackOn = Exception.class)
    public void save(String idMess) throws IOException {
        if (customerRepository.findByIdMessenger(idMess) == null) {
//            String json = CallApi.post(StringApiFB.GET_INFO_USER.replace("<PSID>", idMess).replace("<TOKEN>", StringApiFB.ACCESS_TOKEN_PAGE), null);
//            Gson gson = new Gson();
//            InfoCustomer infoCustomer = gson.fromJson(json, InfoCustomer.class);
//            System.out.println(json);
            Customer customer = new Customer();
            customer.setIdMessenger(idMess);
//            customer.setName(infoCustomer.getName());
//            customer.setProfile_pic(infoCustomer.getProfile_pic());
            customerRepository.save(customer);
        }
    }

    @Override
    public void delete(String idMess) {
        Customer customer = new Customer();
        customer.setIdMessenger(idMess);
        customerRepository.delete(customer);
    }

    @Override
    @Cacheable(cacheNames = StringMessage.USER_CACHE, key = "#id")
    public Customer findAnotherPartner(String id) {
        Customer customer = customerRepository.findByIdMessenger(id);
        Couple couple = coupleRepository.findByIdMessFirst(customer);
        if (couple != null) {
            return couple.getIdMessSecond();
        } else {
            couple = coupleRepository.findByIdMessSecond(customer);
            return couple.getIdMessFirst();
        }
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .peek(i -> i.setId(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new ObjectId(i.getId()).getDate())))
                .collect(Collectors.toList());
    }
}
