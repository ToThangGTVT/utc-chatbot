
package com.utc.chatbot.entity.notifi;

import java.util.List;

public class Payload {

    private String templateType;
    private List<Element> elements = null;

    @Override
    public String toString() {
        return "Payload{" +
                "templateType='" + templateType + '\'' +
                ", elements=" + elements +
                '}';
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

}
