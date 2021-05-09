package com.utc.chatbot.common;

public final class StringApiFB {
    public static final String FB_GRAPH_API_URL_MESSAGES = "https://graph.facebook.com/v9.0/me/messages?access_token=%s";
    public static final String ACCESS_TOKEN_PAGE = System.getenv("ACCESS_TOKEN_PAGE");
    public static final String VERIFY_TOKEN = "hub.verify_token";
    public static final String MODE = "hub.mode";
    public static final String CHALLENGE = "hub.challenge";
    public static final String VERIFICATION_CODE = "utc.chatbot";
    public static final String SIGNATURE = "X-Hub-Signature";
}
