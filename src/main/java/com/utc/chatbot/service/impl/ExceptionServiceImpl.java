package com.utc.chatbot.service.impl;

import com.utc.chatbot.entity.sys.ExceptionMessage;
import com.utc.chatbot.repository.ExceptionRepository;
import com.utc.chatbot.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Autowired
    private ExceptionRepository exceptionRepository;

    @Override
    public void save(ExceptionMessage e) {
        exceptionRepository.save(e);
    }

    @Override
    public List<ExceptionMessage> findAll() {
        return exceptionRepository.findAll();
    }
}
