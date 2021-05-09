package com.utc.chatbot.repository;

import com.utc.chatbot.entity.database.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByIdMessenger(String id);
}
