package com.riderspoint.user_service.entity;

import java.time.LocalDate;

import com.riderspoint.user_service.constants.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "user_profile")
@Builder
@Data
public class UserProfileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	private String first_name;
	private String last_name;
	private String mobile_number;
	private String city;
	private LocalDate date_of_birth;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String about_me;
	
	private boolean emergencyResponder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bike_id", referencedColumnName = "id")
    private BikeDetailsEntity bikeDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "riding_id", referencedColumnName = "id")
    private RidingDetailsEntity ridingDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "social_id", referencedColumnName = "id")
    private SocialDetailsEntity socialDetails;
}
