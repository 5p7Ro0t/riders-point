package com.riderspoint.auth_service.service.impl;

import org.springframework.stereotype.Service;

import com.riderspoint.auth_service.service.interfaces.SmsService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSmsService implements SmsService{
	@Override
	public void sendSms(String to, String messageBody) {
		// TODO Auto-generated method stub
//		Message message = Message.creator(
//				new PhoneNumber(to),
//				new PhoneNumber(config.getPhoneNumber()),
//				messageBody
//				).create();
	}
}
