package com.utc.chatbot.entity.send.notifyimage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class Message {
    @JsonProperty("attachment")
    public Attachment getAttachment() {
        return this.attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    Attachment attachment;
}
