
package com.utc.chatbot.entity.menu.event;

import java.util.List;

public class Entry {

    private String id;
    private String time;
    private List<Messaging> messaging = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Messaging> getMessaging() {
        return messaging;
    }

    public void setMessaging(List<Messaging> messaging) {
        this.messaging = messaging;
    }

}
