package com.riderspoint.auth_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Component
@ConfigurationProperties(prefix = "twilio")
@Data
public class TwilioConfig {
	private String accountSid;
	 private String authToken;
	 private String phoneNumber;

//    @PostConstruct
//    public void init() {
//        Twilio.init(accountSid, authToken);
//    }

	    // Getters and Setters
}
