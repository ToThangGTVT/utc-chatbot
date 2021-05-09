package com.utc.chatbot.repository;

import com.utc.chatbot.entity.sys.NotifyMessenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotifyMessengerRepository extends MongoRepository<NotifyMessenger, Integer> {


}
