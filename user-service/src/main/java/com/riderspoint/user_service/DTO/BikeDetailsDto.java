package com.riderspoint.user_service.DTO;

import com.riderspoint.user_service.constants.BikeType;

import lombok.Builder;

@Builder
public class BikeDetailsDto{
	private BikeType bike_type;
	private String bike_model;
	private int km_ridden;
}
