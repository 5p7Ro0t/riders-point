package com.riderspoint.auth_service.pojo;

import lombok.Data;
import lombok.Getter;

@Data
public class OtpVerificationRequest {
	private String phoneNo;
	private String otp;
	
}
