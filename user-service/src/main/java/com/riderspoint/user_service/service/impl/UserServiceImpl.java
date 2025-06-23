package com.riderspoint.user_service.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.riderspoint.user_service.DTO.UserProfileDto;
import com.riderspoint.user_service.entity.UserProfileEntity;
import com.riderspoint.user_service.repository.UserProfileRepository;
import com.riderspoint.user_service.service.interfaces.UserService;
import com.riderspoint.user_service.utility.JwtService;

@Service
public class UserServiceImpl implements UserService {

	private final UserProfileRepository userRepo; 
	private ModelMapper modelMapper;
	private JwtService jwtService;
	
	public UserServiceImpl(UserProfileRepository userRepo, ModelMapper modelMapper, JwtService jwtService) {
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
		this.jwtService = jwtService;
	}
	
	@Override
	public UserProfileDto getUserProfile(String authToken) {
		// TODO Auto-generated method stub
		
		String username = jwtService.extractSubject(authToken);
		
		Optional<UserProfileEntity> userOpt = userRepo.findByUsername(username);
		
		
		if(userOpt.isPresent()) {
			UserProfileEntity userProfileEntity = userOpt.get();
			UserProfileDto userProfileDto = modelMapper.map(userProfileEntity, UserProfileDto.class);
			return userProfileDto;
		}
		else {
			
		}
		return null;
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
		userRepo.findByUsername(username);
	}
}