package com.riderspoint.user_service.entity;

import com.riderspoint.user_service.constants.BikeType;

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
@Table(name = "bike_details")
@Data
public class BikeDetailsEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 
	@Enumerated(EnumType.STRING)
	private BikeType bike_type;
	
	private String bike_model;
	private Integer km_ridden;
	
	@OneToOne(mappedBy = "bikeDetails")
    private UserProfileEntity userProfile;
}
