
package com.utc.chatbot.entity.quickreply.gennerateclient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuickReply {

    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("payload")
    @Expose
    private String payload;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
