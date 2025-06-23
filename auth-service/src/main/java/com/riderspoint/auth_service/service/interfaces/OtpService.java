package com.riderspoint.auth_service.service.interfaces;

public interface OtpService {
	void sendOtp(String phone_no);
	String verifyOpt(String phone_no, String otp);
}
