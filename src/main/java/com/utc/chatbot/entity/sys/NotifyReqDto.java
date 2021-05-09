package com.utc.chatbot.entity.sys;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotifyReqDto {

    private String urlImg;

    private String title;

    private String content;

}
