
package com.utc.chatbot.entity.receive.text;

import java.util.List;

public class Message {

    private String mid;
    private String text;
    private QuickReply quick_reply;
    private List<Attachment> attachments;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuickReply getQuick_reply() {
        return quick_reply;
    }

    public void setQuick_reply(QuickReply quick_reply) {
        this.quick_reply = quick_reply;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
