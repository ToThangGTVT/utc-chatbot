package com.utc.chatbot.service.impl;

import com.google.gson.Gson;
import com.utc.chatbot.common.StringApiFB;
import com.utc.chatbot.common.StringMessage;
import com.utc.chatbot.entity.database.Customer;
import com.utc.chatbot.entity.menu.event.EntityMenu;
import com.utc.chatbot.entity.quickreply.receiveserver.QuickReplyServer;
import com.utc.chatbot.entity.receive.text.EntityReceive;
import com.utc.chatbot.entity.receive.text.Message;
import com.utc.chatbot.exception.CustomerNotFoundException;
import com.utc.chatbot.service.CoupleService;
import com.utc.chatbot.service.CustomerService;
import com.utc.chatbot.service.MessengerService;
import com.utc.chatbot.utils.CallApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class MessengerServiceImpl implements MessengerService {

    private final CacheManager cacheManager;
    private final CustomerService customerService;
    private final CoupleService coupleService;

    @Autowired
    public MessengerServiceImpl(CacheManager cacheManager,
                                CustomerService customerService,
                                CoupleService coupleService) {
        this.cacheManager = cacheManager;
        this.customerService = customerService;
        this.coupleService = coupleService;
    }

    private final Gson gson = new Gson();

    private Map<String, String> option = new HashMap<>();

    public void handleMessageText(String payload, com.utc.chatbot.entity.receive.text.Message message)
            throws IOException, CustomerNotFoundException {

        EntityReceive entityReceive;
        entityReceive = gson.fromJson(payload, EntityReceive.class);
        String idUser = entityReceive.getEntry().get(0).getMessaging().get(0).getSender().getId();
        String text = message.getText();
        if (coupleService.isExist(idUser)) {
            Customer customer = customerService.findAnotherPartner(idUser);
            if (customer != null) {
                if (text.equals("pp") || text.equals("Pp") || text.equals("PP")) {
                    handleMenuEnd(payload);
                    return;
                }
                String idPartner = customer.getIdMessenger();
                CallApi.sendText(idPartner, text);
            } else {
                CallApi.sendNotify(idUser,
                        StringMessage.NOTIFY_TITLE_REQUEST_TO_WAIT,
                        StringMessage.NOTIFY_BODY_REQUEST_TO_WAIT);
            }
        } else {
            CallApi.sendNotifyWithButton(idUser,
                    StringMessage.NOTIFY_TITLE_NO_CONNECT,
                    StringMessage.NOTIFY_BODY_NO_CONNECT,
                    StringMessage.NOTIFY_BUTTON_NO_CONNECT,
                    "BEGIN");
        }
    }

    @Override
    public void handleMessageAttachment(String payload, Message message) throws IOException {
        EntityReceive entityReceive;
        entityReceive = gson.fromJson(payload, EntityReceive.class);
        String idUser = entityReceive.getEntry().get(0).getMessaging().get(0).getSender().getId();
        if (coupleService.isExist(idUser)) {
            Customer customer = customerService.findAnotherPartner(idUser);
            if (customer != null) {
                String idPartner = customer.getIdMessenger();
                String url = entityReceive.getEntry().get(0).getMessaging().get(0)
                        .getMessage().getAttachments()
                        .get(0).getPayload().getUrl();
                String type = entityReceive.getEntry().get(0).getMessaging().get(0)
                        .getMessage().getAttachments()
                        .get(0).getType();
                if (url.contains("p100x100") || url.contains("mp4")) {
                    CallApi.sendAttachment(idPartner, url, type);
                } else {
                    CallApi.sendNotifyWithUrl(idPartner,
                            StringMessage.NOTIFY_TITLE_SEND_FILE,
                            StringMessage.NOTIFY_BODY_SEND_FILE,
                            StringMessage.NOTIFY_BUTTON_SEND_FILE,
                            url);
                }

            }
        } else {
            CallApi.sendNotifyWithButton(idUser,
                    StringMessage.NOTIFY_TITLE_NO_CONNECT,
                    StringMessage.NOTIFY_BODY_NO_CONNECT,
                    StringMessage.NOTIFY_BUTTON_NO_CONNECT,
                    "BEGIN");
        }
    }

    public void handleMenuBegin(String payload) throws IOException {
        EntityMenu entityMenu = gson.fromJson(payload, EntityMenu.class);
        String idUser = entityMenu.getEntry().get(0).getMessaging().get(0).getSender().getId();
        customerService.save(idUser);
        if (!coupleService.isExist(idUser)) {
            coupleService.saveCouple(idUser, null);
        } else {
            CallApi.sendNotifyWithButton(idUser,
                    StringMessage.NOTIFY_TITLE_MUST_DISCONNECT,
                    StringMessage.NOTIFY_BODY_MUST_DISCONNECT,
                    StringMessage.NOTIFY_BUTTON_MUST_DISCONNECT,
                    "END");

        }
    }

    public void handleMenuEnd(String payload) throws IOException, CustomerNotFoundException {
        EntityMenu entityMenu = gson.fromJson(payload, EntityMenu.class);
        String idUser = entityMenu.getEntry().get(0).getMessaging().get(0).getSender().getId();
        if (coupleService.isExist(idUser)) {
            String json = "{\n" +
                    "  \"recipient\":{\n" +
                    "    \"id\":\"" + idUser + "\"\n" +
                    "  },\n" +
                    "  \"messaging_type\": \"RESPONSE\",\n" +
                    "  \"message\":{\n" +
                    "    \"text\": \" ⚠ Bạn chắc chắn muốn ngắt kết nối\",\n" +
                    "    \"quick_replies\":[\n" +
                    "      {\n" +
                    "        \"content_type\":\"text\",\n" +
                    "        \"title\":\"CANCEL\",\n" +
                    "        \"payload\":\"CFM_CANCEL\"\n" +
                    "      },{\n" +
                    "        \"content_type\":\"text\",\n" +
                    "        \"title\":\"YES\",\n" +
                    "        \"payload\":\"CFM_END\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}";
            CallApi.post(String.format(StringApiFB.FB_GRAPH_API_URL_MESSAGES, StringApiFB.ACCESS_TOKEN_PAGE),
                    json.replace("+", ""));
        } else {
            CallApi.sendNotifyWithButton(idUser,
                    StringMessage.NOTIFY_TITLE_NO_CONNECT,
                    StringMessage.NOTIFY_BODY_NO_CONNECT,
                    StringMessage.NOTIFY_BUTTON_NO_CONNECT,
                    "BEGIN");
        }
    }

    @Override
    public void handleMenuCfmEnd(String payload) throws IOException, CustomerNotFoundException {
        EntityMenu entityMenu = gson.fromJson(payload, EntityMenu.class);
        String idUser = entityMenu.getEntry().get(0).getMessaging().get(0).getSender().getId();
        Customer customer = customerService.findAnotherPartner(idUser);
        option.put("BEGIN-1", StringMessage.NOTIFY_FIND_GIRL);
        option.put("BEGIN-2", StringMessage.NOTIFY_FIND_BOY);
//        option.put("BEGIN-3", StringMessage.NOTIFY_FIND_RANDOM);
        if (customer != null) {
            String idStrangers = customer.getIdMessenger();
            deleteCoupleCache(idStrangers);
            CallApi.sendNotifyWithButton(idStrangers,
                    StringMessage.NOTIFY_TITLE_2_DISCONNECT_1,
                    StringMessage.NOTIFY_BODY_2_DISCONNECT_1,
                    StringMessage.NOTIFY_BUTTON_2_DISCONNECT_1,
                    "BEGIN");
            CallApi.sendQuickReply(option, StringMessage.NOTIFY_TITLE_FIND_GENDER, idStrangers);
        }
        coupleService.deleteCouple(idUser);
        deleteCoupleCache(idUser);
        CallApi.sendNotifyWithButton(idUser,
                StringMessage.NOTIFY_TITLE_1_DISCONNECT_2,
                StringMessage.NOTIFY_BODY_1_DISCONNECT_2,
                StringMessage.NOTIFY_BUTTON_1_DISCONNECT_2,
                "BEGIN");
        CallApi.sendQuickReply(option, StringMessage.NOTIFY_TITLE_FIND_GENDER, idUser);
    }

    private void deleteCoupleCache(String idMess) {
        Objects.requireNonNull(cacheManager.getCache(StringMessage.IS_EXIST_USER_CACHE)).evict(idMess);
        Objects.requireNonNull(cacheManager.getCache(StringMessage.USER_CACHE)).evict(idMess);
    }

    @Override
    public void handleMenuGender(String payload) throws IOException {
        QuickReplyServer quickReplyServer = gson.fromJson(payload, QuickReplyServer.class);
        String optionChat = quickReplyServer.getEntry().get(0).getMessaging().get(0).getMessage().getQuickReply().getPayload();
        System.out.println("3::::" + optionChat);
        if (optionChat.equals("BEGIN-1") || optionChat.equals("BEGIN-2") || optionChat.equals("BEGIN-3")) {
            String idUser = quickReplyServer.getEntry().get(0).getMessaging().get(0).getSender().getId();
            Customer customer = new Customer();
            customer.setIdMessenger(idUser);

            if (coupleService.isExist(idUser)) {
                System.out.println("5:::::");
                CallApi.sendNotifyWithButton(idUser,
                        StringMessage.NOTIFY_TITLE_MUST_DISCONNECT,
                        StringMessage.NOTIFY_BODY_MUST_DISCONNECT,
                        StringMessage.NOTIFY_BUTTON_MUST_DISCONNECT,
                        "END");
                return;
            }

            System.out.println("4:::::");
            // kiểm tra sự tồn tại của user này trong db
            // nếu ko thấy thì lưu lại vảo bảng customer
            // nếu có thì chuyển đến bước tiếp
            customerService.save(customer);

            // lưu thông tin user vào bảng Couple theo từng giới tính
            if(optionChat.equals("BEGIN-1")){
                coupleService.saveCouple(idUser, 1);
            } else {
                coupleService.saveCouple(idUser, 2);
            }
        }
    }

    @Override
    public void handleShowBubbleMenu(String payload) throws IOException {
        EntityMenu entityMenu = gson.fromJson(payload, EntityMenu.class);
        String idUser = entityMenu.getEntry().get(0).getMessaging().get(0).getSender().getId();

        if(coupleService.isExist(idUser)){
            CallApi.sendNotifyWithButton(idUser,
                    StringMessage.NOTIFY_TITLE_MUST_DISCONNECT,
                    StringMessage.NOTIFY_BODY_MUST_DISCONNECT,
                    StringMessage.NOTIFY_BUTTON_MUST_DISCONNECT,
                    "END");
            return;
        }
        option.put("BEGIN-1", StringMessage.NOTIFY_FIND_GIRL);
        option.put("BEGIN-2", StringMessage.NOTIFY_FIND_BOY);
//        option.put("BEGIN-3", StringMessage.NOTIFY_FIND_RANDOM);
        CallApi.sendQuickReply(option, StringMessage.NOTIFY_TITLE_FIND_GENDER, idUser);
    }
}
