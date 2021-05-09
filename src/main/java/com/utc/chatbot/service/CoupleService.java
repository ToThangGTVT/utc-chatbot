package com.utc.chatbot.service;

import com.utc.chatbot.entity.database.Couple;
import com.utc.chatbot.exception.CustomerNotFoundException;

import java.io.IOException;
import java.util.List;

public interface CoupleService {

    void saveCouple(String idMess , Integer criteria) throws IOException;

    void deleteCouple(String idMess) throws CustomerNotFoundException;

    Boolean isExist(String idMess);

    List<Couple> findAll();
}
