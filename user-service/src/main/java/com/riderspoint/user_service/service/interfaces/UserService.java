package com.riderspoint.user_service.service.interfaces;

import com.riderspoint.user_service.DTO.UserProfileDto;

public interface UserService {
	UserProfileDto getUserProfile(String token);
	void createUserProfile(String token, UserProfileDto profile);
    void updateBasicProfile(String token, UserProfileDto profile);
}
