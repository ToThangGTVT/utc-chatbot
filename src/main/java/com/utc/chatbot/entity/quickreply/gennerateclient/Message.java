
package com.utc.chatbot.entity.quickreply.gennerateclient;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("quick_replies")
    @Expose
    private List<QuickReply> quickReplies = null;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<QuickReply> getQuickReplies() {
        return quickReplies;
    }

    public void setQuickReplies(List<QuickReply> quickReplies) {
        this.quickReplies = quickReplies;
    }

}
