package com.riderspoint.user_service.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.riderspoint.user_service.DTO.UserProfileDto;
import com.riderspoint.user_service.entity.UserProfileEntity;
import com.riderspoint.user_service.repository.UserProfileRepository;
import com.riderspoint.user_service.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserProfileRepository userRepo; 
	private ModelMapper modelMapper;
	
	public UserServiceImpl(UserProfileRepository userRepo, ModelMapper modelMapper) {
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public UserProfileDto getUserProfile(String username) {
		// TODO Auto-generated method stub
		
		Optional<UserProfileEntity> userOpt = userRepo.findByUsername(username);
		UserProfileEntity userProfileEntity = null;
		
		if(userOpt.isPresent()) {
			userProfileEntity = userOpt.get();
		}
		else {
			
		}
		UserProfileDto userProfileDto = modelMapper.map(userProfileEntity, UserProfileDto.class);
		return userProfileDto;
	}

	@Override
	public void createUserProfile(String username, UserProfileDto profile) {
		// TODO Auto-generated method stub
		Optional<UserProfileEntity> userOpt = userRepo.findByUsername(username);
		if(userOpt.isEmpty()) {
			UserProfileEntity userProfileEntity = modelMapper.map(profile, UserProfileEntity.class);
			userRepo.save(userProfileEntity);
		}
		else {
			
		}
	}

	@Override
	public void updateBasicProfile(String username, UserProfileDto profile) {
		// TODO Auto-generated method stub

	}

}
