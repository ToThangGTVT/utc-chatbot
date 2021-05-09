package com.utc.chatbot.repository;

import com.utc.chatbot.entity.database.Couple;
import com.utc.chatbot.entity.database.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CoupleRepository extends MongoRepository<Couple, String> {

    Couple findByIdMessSecond(Customer idMessSecond);

    Couple findByIdMessFirst(Customer idCustomerFirst);

    List<Couple> findAllByIdMessSecond(Customer idMessSecond);

    Couple findByCriteriaFirstAndCriteriaSecond(Integer criteria1, Integer criteria2);
}
