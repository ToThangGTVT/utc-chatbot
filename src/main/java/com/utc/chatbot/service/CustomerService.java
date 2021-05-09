package com.utc.chatbot.service;

import com.utc.chatbot.entity.database.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void save(Customer customer);

    void save(String idMess) throws IOException;

    void delete(String idMess);

    Customer findAnotherPartner(String id);

    List<Customer> findAll();
}
