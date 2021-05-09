package com.utc.chatbot.entity.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Couple {

    private String id;

    private Customer idMessFirst;

    private Integer criteriaFirst;

    private Customer idMessSecond;

    private Integer criteriaSecond;

    @Override
    public String toString() {
        return "Couple{" +
                "id='" + id + '\'' +
                ", idMessFirst=" + idMessFirst +
                ", criteriaFirst=" + criteriaFirst +
                ", idMessSecond=" + idMessSecond +
                ", criteriaSecond=" + criteriaSecond +
                '}';
    }
}
