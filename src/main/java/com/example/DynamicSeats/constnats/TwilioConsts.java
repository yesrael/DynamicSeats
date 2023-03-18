package com.example.DynamicSeats.constnats;

import com.twilio.type.PhoneNumber;

public class TwilioConsts {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACcf2055b6f5b49de783b61a43b28e7f31";
    public static final String AUTH_TOKEN = "0d86635431378188e22da61b375f1da3";
    // The WhatsApp number to read messages from
    public static final PhoneNumber WHATSAPP_NUMBER = new PhoneNumber("whatsapp:+14155238886");
    public static final String WHATSAPP_USER_NAME = "Israel";
    // The delay between each check for new messages (in milliseconds)
    public static final long DELAY_MS = 1000;
    public static final String TO_PHONE_NUMBER = "whatsapp:+972543150898";
    public static final String FROM_PHONE_NUMBER = "whatsapp:+14155238886";


}
