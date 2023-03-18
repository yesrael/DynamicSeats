package com.example.DynamicSeats.service;

import com.example.DynamicSeats.constnats.TwilioConsts;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Slf4j
@Service
public class WriteMessage {

    public Message writeMessage(String messageText){
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(TwilioConsts.TO_PHONE_NUMBER),
                        new com.twilio.type.PhoneNumber(TwilioConsts.FROM_PHONE_NUMBER),
                        messageText)
                .create();

        log.info("message was sent: " + message.getBody() + " in: " + ZonedDateTime.now());
        return message;
    }
}
