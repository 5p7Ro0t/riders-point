package com.riderspoint.user_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.riderspoint.user_service.DTO.RidingDetailsDto;
import com.riderspoint.user_service.entity.RidingDetailsEntity;
import com.riderspoint.user_service.entity.UserProfileEntity;
import com.riderspoint.user_service.repository.UserProfileRepository;
import com.riderspoint.user_service.service.interfaces.RidingService;

@Service
public class RidingServiceImpl implements RidingService {

	private final UserProfileRepository userRepo;
	private final ModelMapper modelMapper;
	public RidingServiceImpl(UserProfileRepository userRepo, ModelMapper modelMapper) {
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public RidingDetailsDto getRidingDetails(String username) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void addRidingDetails(String username, RidingDetailsDto details) {
		// TODO Auto-generated method stub
		UserProfileEntity user = userRepo.findByUsername(username)
		        .orElseThrow(() -> new RuntimeException("User not found"));

		if (user.getRidingDetails() == null) {
	        RidingDetailsEntity ridingDetailsEntity = modelMapper.map(details, RidingDetailsEntity.class);

	        ridingDetailsEntity.setUserProfile(user);    
	        user.setRidingDetails(ridingDetailsEntity); 
	        userRepo.save(user);
	    }	
		
		else {
			
		}
	}

	@Override
	public void updateRidingDetails(String username, RidingDetailsDto details) {
		// TODO Auto-generated method stub

	}

}
