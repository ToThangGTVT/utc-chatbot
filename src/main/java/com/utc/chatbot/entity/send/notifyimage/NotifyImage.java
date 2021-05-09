package com.utc.chatbot.entity.send.notifyimage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;


@ToString
public class NotifyImage{
    @JsonProperty("recipient")
    public Recipient getRecipient() {
        return this.recipient; }
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient; }
    Recipient recipient;
    @JsonProperty("message")
    public Message getMessage() {
        return this.message; }
    public void setMessage(Message message) {
        this.message = message; }
    Message message;
}


