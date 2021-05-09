package com.utc.chatbot.utils;

import com.utc.chatbot.entity.notifi.*;

import java.util.ArrayList;
import java.util.List;

public class Json {

    public static Notify buildNotify(String title, String subTitle, String idMess){
        Element element = new Element();
        element.setTitle(title);
        element.setSubtitle(subTitle);
        Payload payload = new Payload();
        List<Element> elements = new ArrayList<>();
        elements.add(element);
        payload.setElements(elements);
        payload.setTemplateType("generic");
        Attachment attachment = new Attachment();
        attachment.setType("template");
        attachment.setPayload(payload);
        Message message = new Message();
        message.setAttachment(attachment);
        Recipient recipient = new Recipient();
        recipient.setId(idMess);
        Notify notify = new Notify();
        notify.setMessage(message);
        notify.setRecipient(recipient);
        return notify;
    }
}
