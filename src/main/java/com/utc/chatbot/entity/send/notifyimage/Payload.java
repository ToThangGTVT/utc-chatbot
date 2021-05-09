package com.utc.chatbot.entity.send.notifyimage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.List;

@ToString
public class Payload {
    @JsonProperty("template_type")
    public String getTemplate_type() {
        return this.template_type;
    }

    public void setTemplate_type(String template_type) {
        this.template_type = template_type;
    }

    String template_type;

    @JsonProperty("elements")
    public List<Element> getElements() {
        return this.elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    List<Element> elements;
}
