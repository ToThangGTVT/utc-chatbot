
package com.utc.chatbot.entity.quickreply.receiveserver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("mid")
    @Expose
    private String mid;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("quick_reply")
    @Expose
    private QuickReply quickReply;

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

    public QuickReply getQuickReply() {
        return quickReply;
    }

    public void setQuickReply(QuickReply quickReply) {
        this.quickReply = quickReply;
    }

}
