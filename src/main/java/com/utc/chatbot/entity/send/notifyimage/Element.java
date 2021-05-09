package com.utc.chatbot.entity.send.notifyimage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.List;

@ToString
public class Element {
    @JsonProperty("title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    @JsonProperty("image_url")
    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    String image_url;

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    String subtitle;

    @JsonProperty("default_action")
    public DefaultAction getDefault_action() {
        return this.default_action;
    }

    public void setDefault_action(DefaultAction default_action) {
        this.default_action = default_action;
    }

    DefaultAction default_action;

    @JsonProperty("buttons")
    public List<Button> getButtons() {
        return this.buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    List<Button> buttons;
}
