package com.riderspoint.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "social_details")
@Data
public class SocialDetailsEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String linkedin_url;
	private String instagram_url;
	private String youtube_url;
	
	@OneToOne(mappedBy = "socialDetails")
    private UserProfileEntity userProfile;
}
