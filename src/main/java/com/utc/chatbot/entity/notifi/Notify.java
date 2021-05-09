
package com.utc.chatbot.entity.notifi;

public class Notify {

    private Recipient recipient;
    private Message message;

    @Override
    public String toString() {
        return "Notify{" +
                "recipient=" + recipient +
                ", message=" + message +
                '}';
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
