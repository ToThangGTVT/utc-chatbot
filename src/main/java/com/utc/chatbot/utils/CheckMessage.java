package com.utc.chatbot.utils;

import com.google.gson.Gson;
import com.utc.chatbot.entity.menu.event.EntityMenu;
import com.utc.chatbot.entity.menu.event.Postback;
import com.utc.chatbot.entity.receive.text.EntityReceive;
import com.utc.chatbot.entity.receive.text.Message;

public class CheckMessage {

    public static Message isTextMessage(String payload) {
        Gson gson = new Gson();
        EntityReceive entityReceive = gson.fromJson(payload, EntityReceive.class);
        return entityReceive.getEntry().get(0).getMessaging().get(0).getMessage();
    }

    public static Postback isMenuMessage(String payload) {
        Gson gson = new Gson();
        EntityMenu entityReceive = gson.fromJson(payload, EntityMenu.class);
        return entityReceive.getEntry().get(0).getMessaging().get(0).getPostback();
    }
}

