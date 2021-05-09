package com.utc.chatbot.entity.sys;

public class StringMessageDto {

    private String NOTIFY_TITLE_GENERAL;
    private String NOTIFY_FOUNDED_STRANGER;

    private String NOTIFY_TITLE_FOUNDING_STRANGER;
    private String NOTIFY_FOUNDING_STRANGER;
    private String NOTIFY_BEGIN = "";

    // khi chưa được kết nối với ai
    private String NOTIFY_TITLE_NO_CONNECT;
    private String NOTIFY_BODY_NO_CONNECT;
    private String NOTIFY_BUTTON_NO_CONNECT;

    // khi gửi tin nhắn mà ko có ai
    private String NOTIFY_TITLE_REQUEST_TO_WAIT;
    private String NOTIFY_BODY_REQUEST_TO_WAIT;

    // khi gửi tệp đính kèm
    private String NOTIFY_TITLE_SEND_FILE;
    private String NOTIFY_BODY_SEND_FILE;
    private String NOTIFY_BUTTON_SEND_FILE;

    // khi chưa ngắt kết nối mà ấn nút bắt đầu
    private String NOTIFY_TITLE_MUST_DISCONNECT;
    private String NOTIFY_BODY_MUST_DISCONNECT;
    private String NOTIFY_BUTTON_MUST_DISCONNECT;

    // bong bóng tìm người lạ
    private String NOTIFY_TITLE_FIND_GENDER;
    private String NOTIFY_FIND_GIRL;
    private String NOTIFY_FIND_BOY;
    private String NOTIFY_FIND_RANDOM;

    // Khi người 1 ngắt kết nối với người 2
    private String NOTIFY_TITLE_1_DISCONNECT_2;
    private String NOTIFY_BODY_1_DISCONNECT_2;
    private String NOTIFY_BUTTON_1_DISCONNECT_2;

    // Khi người 2 ngắt kết nối với người 1
    private String NOTIFY_TITLE_2_DISCONNECT_1;
    private String NOTIFY_BODY_2_DISCONNECT_1;
    private String NOTIFY_BUTTON_2_DISCONNECT_1;

    public String getNotifyTitleGeneral() {
        return NOTIFY_TITLE_GENERAL;
    }

    public String getNotifyFoundedStranger() {
        return NOTIFY_FOUNDED_STRANGER;
    }

    public String getNotifyTitleFoundingStranger() {
        return NOTIFY_TITLE_FOUNDING_STRANGER;
    }

    public String getNotifyFoundingStranger() {
        return NOTIFY_FOUNDING_STRANGER;
    }

    public String getNotifyBegin() {
        return NOTIFY_BEGIN;
    }

    public String getNotifyTitleNoConnect() {
        return NOTIFY_TITLE_NO_CONNECT;
    }

    public String getNotifyBodyNoConnect() {
        return NOTIFY_BODY_NO_CONNECT;
    }

    public String getNotifyButtonNoConnect() {
        return NOTIFY_BUTTON_NO_CONNECT;
    }

    public String getNotifyTitleRequestToWait() {
        return NOTIFY_TITLE_REQUEST_TO_WAIT;
    }

    public String getNotifyBodyRequestToWait() {
        return NOTIFY_BODY_REQUEST_TO_WAIT;
    }

    public String getNotifyTitleSendFile() {
        return NOTIFY_TITLE_SEND_FILE;
    }

    public String getNotifyBodySendFile() {
        return NOTIFY_BODY_SEND_FILE;
    }

    public String getNotifyButtonSendFile() {
        return NOTIFY_BUTTON_SEND_FILE;
    }

    public String getNotifyTitleMustDisconnect() {
        return NOTIFY_TITLE_MUST_DISCONNECT;
    }

    public String getNotifyBodyMustDisconnect() {
        return NOTIFY_BODY_MUST_DISCONNECT;
    }

    public String getNotifyButtonMustDisconnect() {
        return NOTIFY_BUTTON_MUST_DISCONNECT;
    }

    public String getNotifyTitleFindGender() {
        return NOTIFY_TITLE_FIND_GENDER;
    }

    public String getNotifyFindGirl() {
        return NOTIFY_FIND_GIRL;
    }

    public String getNotifyFindBoy() {
        return NOTIFY_FIND_BOY;
    }

    public String getNotifyFindRandom() {
        return NOTIFY_FIND_RANDOM;
    }

    public String getNotifyTitle1Disconnect2() {
        return NOTIFY_TITLE_1_DISCONNECT_2;
    }

    public String getNotifyBody1Disconnect2() {
        return NOTIFY_BODY_1_DISCONNECT_2;
    }

    public String getNotifyButton1Disconnect2() {
        return NOTIFY_BUTTON_1_DISCONNECT_2;
    }

    public String getNotifyTitle2Disconnect1() {
        return NOTIFY_TITLE_2_DISCONNECT_1;
    }

    public String getNotifyBody2Disconnect1() {
        return NOTIFY_BODY_2_DISCONNECT_1;
    }

    public String getNotifyButton2Disconnect1() {
        return NOTIFY_BUTTON_2_DISCONNECT_1;
    }

    public void setNOTIFY_TITLE_GENERAL(String NOTIFY_TITLE_GENERAL) {
        this.NOTIFY_TITLE_GENERAL = NOTIFY_TITLE_GENERAL;
    }

    public void setNOTIFY_FOUNDED_STRANGER(String NOTIFY_FOUNDED_STRANGER) {
        this.NOTIFY_FOUNDED_STRANGER = NOTIFY_FOUNDED_STRANGER;
    }

    public void setNOTIFY_TITLE_FOUNDING_STRANGER(String NOTIFY_TITLE_FOUNDING_STRANGER) {
        this.NOTIFY_TITLE_FOUNDING_STRANGER = NOTIFY_TITLE_FOUNDING_STRANGER;
    }

    public void setNOTIFY_FOUNDING_STRANGER(String NOTIFY_FOUNDING_STRANGER) {
        this.NOTIFY_FOUNDING_STRANGER = NOTIFY_FOUNDING_STRANGER;
    }

    public void setNOTIFY_BEGIN(String NOTIFY_BEGIN) {
        this.NOTIFY_BEGIN = NOTIFY_BEGIN;
    }

    public void setNOTIFY_TITLE_NO_CONNECT(String NOTIFY_TITLE_NO_CONNECT) {
        this.NOTIFY_TITLE_NO_CONNECT = NOTIFY_TITLE_NO_CONNECT;
    }

    public void setNOTIFY_BODY_NO_CONNECT(String NOTIFY_BODY_NO_CONNECT) {
        this.NOTIFY_BODY_NO_CONNECT = NOTIFY_BODY_NO_CONNECT;
    }

    public void setNOTIFY_BUTTON_NO_CONNECT(String NOTIFY_BUTTON_NO_CONNECT) {
        this.NOTIFY_BUTTON_NO_CONNECT = NOTIFY_BUTTON_NO_CONNECT;
    }

    public void setNOTIFY_TITLE_REQUEST_TO_WAIT(String NOTIFY_TITLE_REQUEST_TO_WAIT) {
        this.NOTIFY_TITLE_REQUEST_TO_WAIT = NOTIFY_TITLE_REQUEST_TO_WAIT;
    }

    public void setNOTIFY_BODY_REQUEST_TO_WAIT(String NOTIFY_BODY_REQUEST_TO_WAIT) {
        this.NOTIFY_BODY_REQUEST_TO_WAIT = NOTIFY_BODY_REQUEST_TO_WAIT;
    }

    public void setNOTIFY_TITLE_SEND_FILE(String NOTIFY_TITLE_SEND_FILE) {
        this.NOTIFY_TITLE_SEND_FILE = NOTIFY_TITLE_SEND_FILE;
    }

    public void setNOTIFY_BODY_SEND_FILE(String NOTIFY_BODY_SEND_FILE) {
        this.NOTIFY_BODY_SEND_FILE = NOTIFY_BODY_SEND_FILE;
    }

    public void setNOTIFY_BUTTON_SEND_FILE(String NOTIFY_BUTTON_SEND_FILE) {
        this.NOTIFY_BUTTON_SEND_FILE = NOTIFY_BUTTON_SEND_FILE;
    }

    public void setNOTIFY_TITLE_MUST_DISCONNECT(String NOTIFY_TITLE_MUST_DISCONNECT) {
        this.NOTIFY_TITLE_MUST_DISCONNECT = NOTIFY_TITLE_MUST_DISCONNECT;
    }

    public void setNOTIFY_BODY_MUST_DISCONNECT(String NOTIFY_BODY_MUST_DISCONNECT) {
        this.NOTIFY_BODY_MUST_DISCONNECT = NOTIFY_BODY_MUST_DISCONNECT;
    }

    public void setNOTIFY_BUTTON_MUST_DISCONNECT(String NOTIFY_BUTTON_MUST_DISCONNECT) {
        this.NOTIFY_BUTTON_MUST_DISCONNECT = NOTIFY_BUTTON_MUST_DISCONNECT;
    }

    public void setNOTIFY_TITLE_FIND_GENDER(String NOTIFY_TITLE_FIND_GENDER) {
        this.NOTIFY_TITLE_FIND_GENDER = NOTIFY_TITLE_FIND_GENDER;
    }

    public void setNOTIFY_FIND_GIRL(String NOTIFY_FIND_GIRL) {
        this.NOTIFY_FIND_GIRL = NOTIFY_FIND_GIRL;
    }

    public void setNOTIFY_FIND_BOY(String NOTIFY_FIND_BOY) {
        this.NOTIFY_FIND_BOY = NOTIFY_FIND_BOY;
    }

    public void setNOTIFY_FIND_RANDOM(String NOTIFY_FIND_RANDOM) {
        this.NOTIFY_FIND_RANDOM = NOTIFY_FIND_RANDOM;
    }

    public void setNOTIFY_TITLE_1_DISCONNECT_2(String NOTIFY_TITLE_1_DISCONNECT_2) {
        this.NOTIFY_TITLE_1_DISCONNECT_2 = NOTIFY_TITLE_1_DISCONNECT_2;
    }

    public void setNOTIFY_BODY_1_DISCONNECT_2(String NOTIFY_BODY_1_DISCONNECT_2) {
        this.NOTIFY_BODY_1_DISCONNECT_2 = NOTIFY_BODY_1_DISCONNECT_2;
    }

    public void setNOTIFY_BUTTON_1_DISCONNECT_2(String NOTIFY_BUTTON_1_DISCONNECT_2) {
        this.NOTIFY_BUTTON_1_DISCONNECT_2 = NOTIFY_BUTTON_1_DISCONNECT_2;
    }

    public void setNOTIFY_TITLE_2_DISCONNECT_1(String NOTIFY_TITLE_2_DISCONNECT_1) {
        this.NOTIFY_TITLE_2_DISCONNECT_1 = NOTIFY_TITLE_2_DISCONNECT_1;
    }

    public void setNOTIFY_BODY_2_DISCONNECT_1(String NOTIFY_BODY_2_DISCONNECT_1) {
        this.NOTIFY_BODY_2_DISCONNECT_1 = NOTIFY_BODY_2_DISCONNECT_1;
    }

    public void setNOTIFY_BUTTON_2_DISCONNECT_1(String NOTIFY_BUTTON_2_DISCONNECT_1) {
        this.NOTIFY_BUTTON_2_DISCONNECT_1 = NOTIFY_BUTTON_2_DISCONNECT_1;
    }
}
