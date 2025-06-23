package com.riderspoint.auth_service.service.impl;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.riderspoint.auth_service.service.interfaces.OtpService;
import com.riderspoint.auth_service.utility.JwtService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OtpServiceImpl implements OtpService{
	private final Map<String, String> otpStore =  new ConcurrentHashMap<String, String>();
	private final Random random = new SecureRandom();
	private JwtService jwtService;
	
	
	
	public OtpServiceImpl(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	public void sendOtp(String phone_no) {
		// TODO Auto-generated method stub
		String otp = String.format("%06d", random.nextInt(1000000));
		otpStore.put(phone_no, otp);
		
		
	}

	@Override
	public String verifyOpt(String phone_no, String otp) {
		// TODO Auto-generated method stub
		String token = jwtService.generateToken(phone_no);
		log.info("Token is : {}", token);
		return token;
	}
	
}
