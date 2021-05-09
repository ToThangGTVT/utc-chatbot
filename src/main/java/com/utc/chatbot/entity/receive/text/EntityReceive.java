
package com.utc.chatbot.entity.receive.text;

import java.util.List;

public class EntityReceive {

    private String object;
    private List<Entry> entry = null;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }


}
