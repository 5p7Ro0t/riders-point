package com.riderspoint.user_service.service.interfaces;

import com.riderspoint.user_service.DTO.UserProfileDto;

public interface UserService {
	UserProfileDto getUserProfile(String username);
	void createUserProfile(String username, UserProfileDto profile);
    void updateBasicProfile(String username, UserProfileDto profile);
}
