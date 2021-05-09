
package com.utc.chatbot.entity.quickreply.gennerateclient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MenuQuickReply {

    @SerializedName("recipient")
    @Expose
    private Recipient recipient;
    @SerializedName("messaging_type")
    @Expose
    private String messagingType;
    @SerializedName("message")
    @Expose
    private Message message;

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getMessagingType() {
        return messagingType;
    }

    public void setMessagingType(String messagingType) {
        this.messagingType = messagingType;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
