package com.riderspoint.user_service.pojo;

import com.riderspoint.user_service.constants.RidingStyle;

import lombok.Builder;
import lombok.Data;

@Data
public class RidingDetails {
	private RidingStyle riding_style;
	private int riding_experience;
	private String rider_motto;
	
}
