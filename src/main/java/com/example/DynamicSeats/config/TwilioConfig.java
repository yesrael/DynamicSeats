package com.example.DynamicSeats.config;

import com.example.DynamicSeats.constnats.TwilioConsts;
import com.twilio.Twilio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {

    @Bean
    public void initTwilio() {
        Twilio.init(TwilioConsts.ACCOUNT_SID, TwilioConsts.AUTH_TOKEN);
    }


}
