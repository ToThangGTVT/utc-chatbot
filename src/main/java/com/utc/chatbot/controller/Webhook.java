package com.utc.chatbot.controller;

import com.utc.chatbot.common.StringApiFB;
import com.utc.chatbot.entity.menu.event.Postback;
import com.utc.chatbot.entity.receive.text.Message;
import com.utc.chatbot.entity.sys.NotifyReqDto;
import com.utc.chatbot.exception.CustomerNotFoundException;
import com.utc.chatbot.service.MessengerService;
import com.utc.chatbot.service.NotifyAllService;
import com.utc.chatbot.utils.CheckMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class Webhook {

    private final MessengerService messengerService;
    private final NotifyAllService notifyAllService;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    public Webhook(MessengerService messengerService,
                   NotifyAllService notifyAllService) {
        this.messengerService = messengerService;
        this.notifyAllService = notifyAllService;
    }

    @GetMapping(value = "/webhook")
    public String verify(
            @RequestParam(value = StringApiFB.VERIFY_TOKEN) String token,
            @RequestParam(value = StringApiFB.MODE) String mode,
            @RequestParam(value = StringApiFB.CHALLENGE) String challenge) throws IllegalAccessException {

        if (mode.equals("subscribe") && token.equals(StringApiFB.VERIFICATION_CODE)) {
            return challenge;
        }
        throw new IllegalAccessException();
    }

    /**
     *
     * @param payload BEGIN-1: find female; BEGIN-2: find male;
     * @param signature sign of facebook
     * @return
     * @throws IOException
     * @throws CustomerNotFoundException
     */
    @PostMapping(value = "/webhook")
    public ResponseEntity<Void> webhook(@RequestBody final String payload,
                                         @RequestHeader(StringApiFB.SIGNATURE) final String signature)
            throws IOException, CustomerNotFoundException {
        Message message = CheckMessage.isTextMessage(payload);
        Postback postback = CheckMessage.isMenuMessage(payload);
        if (message != null) {
            if (message.getQuick_reply() == null && message.getAttachments() == null) {
                messengerService.handleMessageText(payload, message);
            } else if (message.getQuick_reply() != null && message.getAttachments() == null) {
                if (message.getQuick_reply().getPayload().equals("CFM_END")) {
                    messengerService.handleMenuCfmEnd(payload);
                } else if(message.getQuick_reply().getPayload().equals("BEGIN-1") || message.getQuick_reply().getPayload().equals("BEGIN-2") || message.getQuick_reply().getPayload().equals("BEGIN-3")){
                    messengerService.handleMenuGender(payload);
                }
            } else if (message.getQuick_reply() == null && message.getAttachments() != null) {
                messengerService.handleMessageAttachment(payload, message);
            }
        } else if ((postback != null) && postback.getPayload().equals("BEGIN")) {
            messengerService.handleShowBubbleMenu(payload);
        } else if ((postback != null) && postback.getPayload().equals("END")) {
            messengerService.handleMenuEnd(payload);
        }

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/send-mess-simultaneously")
    public Boolean handleMessSimultaneously(@RequestBody NotifyReqDto notifyReqDto)
            throws IOException, InterruptedException {

        notifyAllService.sendAllNotify(notifyReqDto);
        return Boolean.TRUE;
    }

    @ExceptionHandler(value = IllegalAccessException.class)
    public ResponseEntity exception403() {
        return new ResponseEntity<Error>(HttpStatus.FORBIDDEN);
    }
}
