
package com.utc.chatbot.entity.notifi;

public class Recipient {

    private String id;

    @Override
    public String toString() {
        return "Recipient{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
