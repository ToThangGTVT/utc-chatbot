package com.utc.chatbot.common;

public class StringMessage {
    public static String NOTIFY_TITLE_GENERAL = "Đã tìm thấy cá";
    public static String NOTIFY_FOUNDED_STRANGER = "Chăm sóc cá cẩn thận nhé ❤. Id cá là: ";

    public static String NOTIFY_TITLE_FOUNDING_STRANGER = "Đang tìm cá cho bạn...";
    public static String NOTIFY_FOUNDING_STRANGER = "Cá đang đi chơi chưa về nhé ⛱";
    public static String NOTIFY_BEGIN = "";

    // khi chưa được kết nối với ai
    public static String NOTIFY_TITLE_NO_CONNECT = "Bạn chưa được kết nối với ai 🤷‍♀️";
    public static String NOTIFY_BODY_NO_CONNECT = "Nhấn nút phía dưới để thả câu";
    public static String NOTIFY_BUTTON_NO_CONNECT = "Tìm cá mới";

    // khi gửi tin nhắn mà ko có ai
    public static String NOTIFY_TITLE_REQUEST_TO_WAIT = "Thông báo";
    public static String NOTIFY_BODY_REQUEST_TO_WAIT = "Vui lòng chờ cho đến khi tìm thấy cá cho bạn";

    // khi gửi tệp đính kèm
    public static String NOTIFY_TITLE_SEND_FILE = "Cá vừa gửi một hình ảnh";
    public static String NOTIFY_BODY_SEND_FILE = "Nhấn nút phía dưới để mở ảnh";
    public static String NOTIFY_BUTTON_SEND_FILE = "Mở ảnh";

    // khi chưa ngắt kết nối mà ấn nút bắt đầu
    public static String NOTIFY_TITLE_MUST_DISCONNECT = "Bạn phải ngắt kết nối với cá hiện tại";
    public static String NOTIFY_BODY_MUST_DISCONNECT = "Ấn nút dưới này";
    public static String NOTIFY_BUTTON_MUST_DISCONNECT = "Ngắt kết nối";

    // bong bóng tìm người lạ
    public static String NOTIFY_TITLE_FIND_GENDER = "\uD83D\uDC1F Thả thính tìm cá thôi nàooo";
    public static String NOTIFY_FIND_GIRL = "Tìm nữ \uD83D\uDE46\u200D♀️‍";
    public static String NOTIFY_FIND_BOY = "Tìm nam 🙆‍♂️";
    public static String NOTIFY_FIND_RANDOM = "Ẩn giới tính";

    // Khi người 1 ngắt kết nối với người 2
    public static String NOTIFY_TITLE_1_DISCONNECT_2 = "Đã ngắt kết nối với cá";
    public static String NOTIFY_BODY_1_DISCONNECT_2 = "Nhấn nút phía dưới để câu bạn cá mới ✌";
    public static String NOTIFY_BUTTON_1_DISCONNECT_2 = "Tìm cá mới";

    // Khi người 2 ngắt kết nối với người 1
    public static String NOTIFY_TITLE_2_DISCONNECT_1 = "Cá đã bơi đi";
    public static String NOTIFY_BODY_2_DISCONNECT_1 = "Nhấn nút phía dưới để câu bạn cá mới ✌";
    public static String NOTIFY_BUTTON_2_DISCONNECT_1 = "Tìm cá mới";

    // cache
    public static final String USER_CACHE = "user";
    public static final String IS_EXIST_USER_CACHE = "isExistUser";

    public static String getNotifyTitleGeneral() {
        return NOTIFY_TITLE_GENERAL;
    }

    public static String getNotifyFoundedStranger() {
        return NOTIFY_FOUNDED_STRANGER;
    }

    public static String getNotifyTitleFoundingStranger() {
        return NOTIFY_TITLE_FOUNDING_STRANGER;
    }

    public static String getNotifyFoundingStranger() {
        return NOTIFY_FOUNDING_STRANGER;
    }

    public static String getNotifyBegin() {
        return NOTIFY_BEGIN;
    }

    public static String getNotifyTitleNoConnect() {
        return NOTIFY_TITLE_NO_CONNECT;
    }

    public static String getNotifyBodyNoConnect() {
        return NOTIFY_BODY_NO_CONNECT;
    }

    public static String getNotifyButtonNoConnect() {
        return NOTIFY_BUTTON_NO_CONNECT;
    }

    public static String getNotifyTitleRequestToWait() {
        return NOTIFY_TITLE_REQUEST_TO_WAIT;
    }

    public static String getNotifyBodyRequestToWait() {
        return NOTIFY_BODY_REQUEST_TO_WAIT;
    }

    public static String getNotifyTitleSendFile() {
        return NOTIFY_TITLE_SEND_FILE;
    }

    public static String getNotifyBodySendFile() {
        return NOTIFY_BODY_SEND_FILE;
    }

    public static String getNotifyButtonSendFile() {
        return NOTIFY_BUTTON_SEND_FILE;
    }

    public static String getNotifyTitleMustDisconnect() {
        return NOTIFY_TITLE_MUST_DISCONNECT;
    }

    public static String getNotifyBodyMustDisconnect() {
        return NOTIFY_BODY_MUST_DISCONNECT;
    }

    public static String getNotifyButtonMustDisconnect() {
        return NOTIFY_BUTTON_MUST_DISCONNECT;
    }

    public static String getNotifyTitleFindGender() {
        return NOTIFY_TITLE_FIND_GENDER;
    }

    public static String getNotifyFindGirl() {
        return NOTIFY_FIND_GIRL;
    }

    public static String getNotifyFindBoy() {
        return NOTIFY_FIND_BOY;
    }

    public static String getNotifyFindRandom() {
        return NOTIFY_FIND_RANDOM;
    }

    public static String getNotifyTitle1Disconnect2() {
        return NOTIFY_TITLE_1_DISCONNECT_2;
    }

    public static String getNotifyBody1Disconnect2() {
        return NOTIFY_BODY_1_DISCONNECT_2;
    }

    public static String getNotifyButton1Disconnect2() {
        return NOTIFY_BUTTON_1_DISCONNECT_2;
    }

    public static String getNotifyTitle2Disconnect1() {
        return NOTIFY_TITLE_2_DISCONNECT_1;
    }

    public static String getNotifyBody2Disconnect1() {
        return NOTIFY_BODY_2_DISCONNECT_1;
    }

    public static String getNotifyButton2Disconnect1() {
        return NOTIFY_BUTTON_2_DISCONNECT_1;
    }
}

