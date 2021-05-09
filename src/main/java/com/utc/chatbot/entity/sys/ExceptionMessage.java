package com.utc.chatbot.entity.sys;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExceptionMessage {

    private String id;

    private String name;

    public ExceptionMessage(String name) {
        this.name = name;
    }
}
