package com.riderspoint.user_service.DTO;

import java.time.LocalDate;

import com.riderspoint.user_service.constants.Gender;

import lombok.Builder;
import lombok.Data;


@Data
public class UserProfileDto {
	private String username;
	private String first_name;
	private String last_name;
	private String mobile_number;
	private String city;
	private LocalDate date_of_birth;
	private String email;
	private Gender gender;
	private String about_me;
}
