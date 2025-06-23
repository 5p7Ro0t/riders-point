package com.riderspoint.auth_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riderspoint.auth_service.pojo.OtpVerificationRequest;
import com.riderspoint.auth_service.service.impl.OtpServiceImpl;
import com.riderspoint.auth_service.service.interfaces.OtpService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private OtpService otpService;
	
	public AuthController(OtpServiceImpl otpServiceImpl) {
		this.otpService = otpServiceImpl;
	}
	
	@PostMapping("/request-otp")
	public void requestOtp(String phone_no) {
		otpService.sendOtp(phone_no);
	}
	
	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOtp(@RequestBody OtpVerificationRequest request) {
		
		log.info("Request Details : {}", request);
		String token = otpService.verifyOpt(request.getPhoneNo(), request.getOtp());
		
		
		return new ResponseEntity<>(token,HttpStatus.OK);
	}
	
	public void handleOAuthLogin() {
		
	}
}
