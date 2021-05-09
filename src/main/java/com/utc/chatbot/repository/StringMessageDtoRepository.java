package com.utc.chatbot.repository;

import com.utc.chatbot.entity.sys.StringMessageDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StringMessageDtoRepository extends MongoRepository<StringMessageDto, String> {


}
