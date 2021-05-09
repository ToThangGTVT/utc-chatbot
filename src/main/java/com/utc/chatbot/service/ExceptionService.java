package com.utc.chatbot.service;

import com.utc.chatbot.entity.sys.ExceptionMessage;

import java.util.List;

public interface ExceptionService {

    void save(ExceptionMessage e);

    List<ExceptionMessage> findAll();
}
