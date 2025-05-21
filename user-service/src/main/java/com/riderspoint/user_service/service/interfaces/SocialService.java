package com.riderspoint.user_service.service.interfaces;

import com.riderspoint.user_service.DTO.SocialDetailsDto;

public interface SocialService {
	SocialDetailsDto getSocialDetails(String username);
	void updateSocialDetails(String username, SocialDetailsDto socialDetails);
}
