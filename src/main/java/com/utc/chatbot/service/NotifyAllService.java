package com.utc.chatbot.service;

import com.utc.chatbot.entity.sys.NotifyReqDto;

import java.io.IOException;

public interface NotifyAllService {

    void sendAllNotify(NotifyReqDto notifyReqDto) throws IOException, InterruptedException;
}
