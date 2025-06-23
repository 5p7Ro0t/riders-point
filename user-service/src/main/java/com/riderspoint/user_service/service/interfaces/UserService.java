package com.riderspoint.user_service.service.interfaces;

import com.riderspoint.user_service.DTO.UserProfileDto;

public interface UserService {
	UserProfileDto getUserProfile(String authToken);
	void createUserProfile(String authToken, UserProfileDto profile);
    void updateBasicProfile(String authToken, UserProfileDto profile);
}
