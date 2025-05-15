package com.riderspoint.user_service.pojo;

import com.riderspoint.user_service.constants.BikeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
	private String username;
	private String first_name;
	private String last_name;
	private BikeType bike_type;
	private int experience;
	private String driving_licence;
	private long mobile_number;
}
