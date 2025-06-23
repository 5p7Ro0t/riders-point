package com.riderspoint.auth_service.service.interfaces;

public interface SmsService {
	void sendSms(String to, String messageBody);
}
