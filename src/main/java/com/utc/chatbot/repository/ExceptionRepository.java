package com.utc.chatbot.repository;

import com.utc.chatbot.entity.sys.ExceptionMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExceptionRepository extends MongoRepository<ExceptionMessage, Integer> {

}
