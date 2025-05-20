package com.riderspoint.user_service.DTO;

import com.riderspoint.user_service.constants.RidingStyle;

import lombok.Data;

@Data
public class RidingDetailsDto {
	private RidingStyle riding_style;
	private int riding_experience;
	private String rider_motto;
	
}
