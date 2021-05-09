package com.utc.chatbot.service;

import com.utc.chatbot.exception.CustomerNotFoundException;

import java.io.IOException;

public interface MessengerService {

    void handleMessageText(String payload, com.utc.chatbot.entity.receive.text.Message message) throws IOException, CustomerNotFoundException;

    void handleMessageAttachment(String payload, com.utc.chatbot.entity.receive.text.Message message) throws IOException;

    void handleMenuBegin(String payload) throws IOException;

    void handleMenuEnd(String payload) throws IOException, CustomerNotFoundException;

    void handleMenuCfmEnd(String payload) throws IOException, CustomerNotFoundException;

    void handleMenuGender(String payload) throws IOException;

    void handleShowBubbleMenu(String payload) throws IOException;
}
