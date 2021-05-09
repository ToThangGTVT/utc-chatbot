package com.utc.chatbot.entity.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String id;

    private String idMessenger;

    private String name;

    private String profile_pic;

    private Couple coupleFirst;

    private Couple coupleSecond;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", idMessenger='" + idMessenger + '\'' +
                ", coupleFirst=" + coupleFirst +
                ", coupleSecond=" + coupleSecond +
                '}';
    }

}
