package com.riderspoint.user_service.entity;

import com.riderspoint.user_service.constants.RidingStyle;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "riding_details")
@Data
public class RidingDetailsEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
	private RidingStyle riding_style;
	
	private int riding_experience;
	private String rider_motto;
	
	
	 @OneToOne(mappedBy = "ridingDetails")
	 private UserProfileEntity userProfile;
}
