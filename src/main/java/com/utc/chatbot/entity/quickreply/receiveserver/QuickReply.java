
package com.utc.chatbot.entity.quickreply.receiveserver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuickReply {

    @SerializedName("payload")
    @Expose
    private String payload;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}
