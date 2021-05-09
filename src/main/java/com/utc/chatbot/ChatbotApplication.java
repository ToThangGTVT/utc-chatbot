package com.utc.chatbot;

import com.utc.chatbot.common.StringMessage;
import com.utc.chatbot.entity.sys.StringMessageDto;
import com.utc.chatbot.repository.StringMessageDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EntityScan(value = "com.utc.chatbot.entity.database")
@EnableScheduling
@EnableCaching
public class ChatbotApplication {

    @Autowired
    private StringMessageDtoRepository stringMessageRepository;

    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
    }

    @Scheduled(fixedRate = 21600000)
    public void reportCurrentTime() {
        StringMessageDto stringMessage = stringMessageRepository.findAll().get(0);
        StringMessage.NOTIFY_TITLE_GENERAL = stringMessage.getNotifyTitleGeneral();
        StringMessage.NOTIFY_FOUNDED_STRANGER = stringMessage.getNotifyFoundedStranger();
        StringMessage.NOTIFY_TITLE_FOUNDING_STRANGER = stringMessage.getNotifyTitleFoundingStranger();
        StringMessage.NOTIFY_FOUNDING_STRANGER = stringMessage.getNotifyFoundingStranger();
        StringMessage.NOTIFY_BEGIN = stringMessage.getNotifyBegin();
        StringMessage.NOTIFY_TITLE_NO_CONNECT = stringMessage.getNotifyTitleNoConnect();
        StringMessage.NOTIFY_BODY_NO_CONNECT = stringMessage.getNotifyBodyNoConnect();
        StringMessage.NOTIFY_BUTTON_NO_CONNECT = stringMessage.getNotifyButtonNoConnect();
        StringMessage.NOTIFY_TITLE_REQUEST_TO_WAIT = stringMessage.getNotifyTitleRequestToWait();
        StringMessage.NOTIFY_BODY_REQUEST_TO_WAIT = stringMessage.getNotifyBodyRequestToWait();
        StringMessage.NOTIFY_TITLE_SEND_FILE = stringMessage.getNotifyTitleSendFile();
        StringMessage.NOTIFY_BODY_SEND_FILE = stringMessage.getNotifyBodySendFile();
        StringMessage.NOTIFY_BUTTON_SEND_FILE = stringMessage.getNotifyButtonSendFile();
        StringMessage.NOTIFY_TITLE_MUST_DISCONNECT = stringMessage.getNotifyTitleMustDisconnect();
        StringMessage.NOTIFY_BODY_MUST_DISCONNECT = stringMessage.getNotifyBodyMustDisconnect();
        StringMessage.NOTIFY_BUTTON_MUST_DISCONNECT = stringMessage.getNotifyButtonMustDisconnect();
        StringMessage.NOTIFY_TITLE_FIND_GENDER = stringMessage.getNotifyTitleFindGender();
        StringMessage.NOTIFY_FIND_GIRL = stringMessage.getNotifyFindGirl();
        StringMessage.NOTIFY_FIND_BOY = stringMessage.getNotifyFindBoy();
        StringMessage.NOTIFY_FIND_RANDOM = stringMessage.getNotifyFindRandom();
        StringMessage.NOTIFY_TITLE_1_DISCONNECT_2 = stringMessage.getNotifyTitle1Disconnect2();
        StringMessage.NOTIFY_BODY_1_DISCONNECT_2 = stringMessage.getNotifyBody1Disconnect2();
        StringMessage.NOTIFY_BUTTON_1_DISCONNECT_2 = stringMessage.getNotifyButton1Disconnect2();
        StringMessage.NOTIFY_TITLE_2_DISCONNECT_1 = stringMessage.getNotifyTitle2Disconnect1();
        StringMessage.NOTIFY_BODY_2_DISCONNECT_1 = stringMessage.getNotifyBody2Disconnect1();
        StringMessage.NOTIFY_BUTTON_2_DISCONNECT_1 = stringMessage.getNotifyButton2Disconnect1();
    }

}
