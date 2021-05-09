package com.utc.chatbot.entity.send.notifyimage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class DefaultAction {
    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    @JsonProperty("url")
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String url;

    @JsonProperty("messenger_extensions")
    public boolean getMessenger_extensions() {
        return this.messenger_extensions;
    }

    public void setMessenger_extensions(boolean messenger_extensions) {
        this.messenger_extensions = messenger_extensions;
    }

    boolean messenger_extensions;

    @JsonProperty("webview_height_ratio")
    public String getWebview_height_ratio() {
        return this.webview_height_ratio;
    }

    public void setWebview_height_ratio(String webview_height_ratio) {
        this.webview_height_ratio = webview_height_ratio;
    }

    String webview_height_ratio;

    @JsonProperty("fallback_url")
    public String getFallback_url() {
        return this.fallback_url;
    }

    public void setFallback_url(String fallback_url) {
        this.fallback_url = fallback_url;
    }

    String fallback_url;
}
