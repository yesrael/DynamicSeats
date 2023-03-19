package com.example.DynamicSeats.constnats;

import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;

public class TwilioParams {


    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC87516ca6119298d418ffaecd16fe7652";
    public static final String AUTH_TOKEN = "b7aa587e91cf12ac5e1e5a6779dceec9";
    // The WhatsApp number to read messages from
    public static final PhoneNumber WHATSAPP_NUMBER = new PhoneNumber("whatsapp:+14155238886");
    public static final String WHATSAPP_USER_NAME = "Israel";
    // The delay between each check for new messages (in milliseconds)
    public static final long DELAY_MS = 1000;
//    public static final String TO_PHONE_NUMBER = "whatsapp:+972543150898";
public static final String TO_PHONE_NUMBER = "whatsapp:+972545757806";
public static final String  PHONE_NUMBER="0545757806";
    public static final String FROM_PHONE_NUMBER = "whatsapp:+14155238886";

}
