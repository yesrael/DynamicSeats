package com.example.DynamicSeats.constnats;

import com.twilio.type.PhoneNumber;

import java.time.ZonedDateTime;

public class TwilioConsts {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACcf2055b6f5b49de783b61a43b28e7f31";
    public static final String AUTH_TOKEN = "888fd9bd236d2685918750aeb07f48b9";
    // The WhatsApp number to read messages from
    public static final PhoneNumber WHATSAPP_NUMBER = new PhoneNumber("whatsapp:+14155238886");
    public static final String WHATSAPP_USER_NAME = "Israel";
    // The delay between each check for new messages (in milliseconds)
    public static final long DELAY_MS = 1000;
    public static final String TO_PHONE_NUMBER = "whatsapp:+972543150898";
    public static final String FROM_PHONE_NUMBER = "whatsapp:+14155238886";

}
