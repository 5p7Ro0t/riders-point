package com.riderspoint.user_service.pojo;

import com.riderspoint.user_service.constants.BikeType;

import lombok.Builder;

@Builder
public class BikeDetails {
	private BikeType bike_type;
	private String bike_model;
	private int km_ridden;
}
