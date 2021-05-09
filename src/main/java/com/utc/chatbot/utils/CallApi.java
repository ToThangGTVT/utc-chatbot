package com.utc.chatbot.utils;

import com.google.gson.Gson;
import com.utc.chatbot.common.StringApiFB;
import com.utc.chatbot.entity.quickreply.gennerateclient.MenuQuickReply;
import com.utc.chatbot.entity.quickreply.gennerateclient.QuickReply;
import com.utc.chatbot.entity.send.text.EntitySend;
import com.utc.chatbot.entity.send.text.Message;
import com.utc.chatbot.entity.send.text.Recipient;
import okhttp3.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CallApi {

    public static void post(String url, String data) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, data);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        response.close();
    }

    public static void sendText(String idUser, String text) throws IOException {
        Gson gson = new Gson();
        EntitySend entitySend = new EntitySend();
        entitySend.setMessagingType("RESPONSE");
        entitySend.setRecipient(new Recipient(idUser));
        entitySend.setMessage(new Message(text));

        post(String.format(StringApiFB.FB_GRAPH_API_URL_MESSAGES, StringApiFB.ACCESS_TOKEN_PAGE),
                gson.toJson(entitySend)
        );
    }

    public static void sendNotify(String idMess, String title, String subTitle) throws IOException {
        String json = "{\n" +
                "  \"recipient\": {\n" +
                "    \"id\": \"" + idMess + "\"\n" +
                "  },\n" +
                "  \"message\": {\n" +
                "    \"attachment\": {\n" +
                "      \"type\": \"template\",\n" +
                "      \"payload\": {\n" +
                "        \"template_type\": \"generic\",\n" +
                "        \"elements\": [\n" +
                "          {\n" +
                "            \"title\": \"" + title + "\",\n" +
                "            \"subtitle\": \"+" + subTitle + "+\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        post(String.format(StringApiFB.FB_GRAPH_API_URL_MESSAGES, StringApiFB.ACCESS_TOKEN_PAGE),
                json.replace("+", "")
        );
    }

    public static void sendNotifyWithButton(String idMess,
                                            String title,
                                            String subTitle,
                                            String titleBtn,
                                            String payload)
            throws IOException {
        String json = "{\n" +
                "  \"recipient\":{\n" +
                "    \"id\":\"" + idMess + "\"\n" +
                "  },\n" +
                "  \"message\":{\n" +
                "    \"attachment\":{\n" +
                "      \"type\":\"template\",\n" +
                "      \"payload\":{\n" +
                "        \"template_type\":\"generic\",\n" +
                "        \"elements\":[\n" +
                "           {\n" +
                "            \"title\":\"" + title + "\",\n" +
                "            \"subtitle\":\"" + subTitle + "\",\n" +
                "            \"buttons\":[\n" +
                "              {\n" +
                "                \"type\":\"postback\",\n" +
                "                \"title\":\"" + titleBtn + "\",\n" +
                "                \"payload\":\"" + payload + "\"\n" +
                "              }              \n" +
                "            ]      \n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        post(String.format(StringApiFB.FB_GRAPH_API_URL_MESSAGES, StringApiFB.ACCESS_TOKEN_PAGE),
                json.replace("+", ""));
    }

    public static void sendNotifyWithUrl(String idMess,
                                         String title,
                                         String subTitle,
                                         String titleBtn,
                                         String url) throws IOException {
        String json = "{\n" +
                "    \"recipient\": {\n" +
                "        \"id\": \"" + idMess + "\"\n" +
                "    },\n" +
                "    \"message\": {\n" +
                "        \"attachment\": {\n" +
                "            \"type\": \"template\",\n" +
                "            \"payload\": {\n" +
                "                \"template_type\": \"generic\",\n" +
                "                \"elements\": [\n" +
                "                    {\n" +
                "                        \"title\": \"" + title + "\",\n" +
                "                        \"subtitle\": \"" + subTitle + "\",\n" +
                "                        \"buttons\": [\n" +
                "                            {\n" +
                "                                \"type\": \"web_url\",\n" +
                "                                \"url\": \"" + url + "\",\n" +
                "                                \"title\": \"" + titleBtn + "\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        post(String.format(StringApiFB.FB_GRAPH_API_URL_MESSAGES, StringApiFB.ACCESS_TOKEN_PAGE),
                json.replace("+", ""));
    }

    public static void sendAttachment(String idMess, String url, String type) throws IOException {
        String json = "{\n" +
                "    \"recipient\": {\n" +
                "        \"id\": \"" + idMess + "\"\n" +
                "    },\n" +
                "    \"message\": {\n" +
                "        \"attachment\": {\n" +
                "            \"type\": \"" + type + "\",\n" +
                "            \"payload\": {\n" +
                "                \"url\": \"" + url + "\",\n" +
                "                \"is_reusable\": true\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        post(String.format(StringApiFB.FB_GRAPH_API_URL_MESSAGES, StringApiFB.ACCESS_TOKEN_PAGE),
                json.replace("+", ""));
    }

    public static void sendQuickReply(Map<String, String> listOption,String textMessage, String idMess) throws IOException {
        MenuQuickReply menuQuickReply = new MenuQuickReply();
        menuQuickReply.setMessagingType("RESPONSE");
        menuQuickReply.setRecipient(new com.utc.chatbot.entity.quickreply.gennerateclient.Recipient(idMess));
        com.utc.chatbot.entity.quickreply.gennerateclient.Message message = new com.utc.chatbot.entity.quickreply.gennerateclient.Message();
        message.setText(textMessage);

        List<QuickReply> quickReplies = new LinkedList<>();
        listOption.forEach((k,v)->{
            QuickReply quickReply = new QuickReply();
            quickReply.setContentType("text");
            quickReply.setTitle(v);
            quickReply.setPayload(k);
            quickReplies.add(quickReply);
        });

        message.setQuickReplies(quickReplies);
        menuQuickReply.setMessage(message);

        Gson gson = new Gson();
        String json = gson.toJson(menuQuickReply);

        post(String.format(StringApiFB.FB_GRAPH_API_URL_MESSAGES, StringApiFB.ACCESS_TOKEN_PAGE), json);
    }
}
