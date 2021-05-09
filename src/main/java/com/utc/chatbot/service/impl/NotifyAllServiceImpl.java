package com.utc.chatbot.service.impl;

import com.google.gson.Gson;
import com.utc.chatbot.entity.database.Customer;
import com.utc.chatbot.entity.send.notifyimage.*;
import com.utc.chatbot.entity.sys.NotifyReqDto;
import com.utc.chatbot.repository.CustomerRepository;
import com.utc.chatbot.service.NotifyAllService;
import com.utc.chatbot.utils.CallApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.utc.chatbot.common.StringApiFB.ACCESS_TOKEN_PAGE;
import static com.utc.chatbot.common.StringApiFB.FB_GRAPH_API_URL_MESSAGES;
import static org.springframework.http.HttpHeaders.USER_AGENT;

@Service
@Slf4j
public class NotifyAllServiceImpl implements NotifyAllService {

    private final CustomerRepository customerRepository;

    private final WebClient webClient;

    private final String FB_GRAPH = String.format(FB_GRAPH_API_URL_MESSAGES, ACCESS_TOKEN_PAGE);

    public NotifyAllServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.webClient = WebClient.builder()
                .baseUrl(FB_GRAPH)
                .defaultHeader(USER_AGENT, USER_AGENT)
                .filter(logRequest())
                .build();
    }

    @Override
    public void sendAllNotify(NotifyReqDto notifyReqDto) throws IOException, InterruptedException {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            String messId = customer.getIdMessenger();
            NotifyImage notifyImage = new NotifyImage();

            Recipient recipient = new Recipient();
            recipient.setId(messId);
            notifyImage.setRecipient(recipient);


            Message message = new Message();
            Attachment attachment = new Attachment();
            attachment.setType("template");

            Payload payload = new Payload();
            attachment.setPayload(payload);
            payload.setTemplate_type("generic");

            List<Element> listElement = new ArrayList<>();
            Element element = new Element();
            element.setTitle(notifyReqDto.getTitle());
            element.setImage_url(notifyReqDto.getUrlImg());
            element.setSubtitle(notifyReqDto.getContent());
            listElement.add(element);

            payload.setElements(listElement);
            message.setAttachment(attachment);
            notifyImage.setMessage(message);

            Gson gson = new Gson();
            CallApi.post(FB_GRAPH, gson.toJson(notifyImage));
            Thread.sleep(1000);
        }
    }

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }
}
