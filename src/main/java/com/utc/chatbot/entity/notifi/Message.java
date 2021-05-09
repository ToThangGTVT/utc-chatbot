
package com.utc.chatbot.entity.notifi;

public class Message {

    private Attachment attachment;

    @Override
    public String toString() {
        return "Message{" +
                "attachment=" + attachment +
                '}';
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

}
