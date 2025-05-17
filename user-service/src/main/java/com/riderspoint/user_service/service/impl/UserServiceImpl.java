package com.riderspoint.user_service.service.impl;

import org.springframework.stereotype.Service;

import com.riderspoint.user_service.DTO.UserProfileDto;
import com.riderspoint.user_service.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserProfileDto getUserProfile(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUserProfile(String token, UserProfileDto profile) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBasicProfile(String token, UserProfileDto profile) {
		// TODO Auto-generated method stub

	}

}
