package com.riderspoint.user_service.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.riderspoint.user_service.DTO.BikeDetailsDto;
import com.riderspoint.user_service.entity.BikeDetailsEntity;
import com.riderspoint.user_service.entity.UserProfileEntity;
import com.riderspoint.user_service.repository.BikeDetailsRepository;
import com.riderspoint.user_service.repository.UserProfileRepository;
import com.riderspoint.user_service.service.interfaces.BikeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BikeServiceImpl implements BikeService {

	private final BikeDetailsRepository bikeRepo;
	private final UserProfileRepository userRepo;
	private final ModelMapper modelMapper;
	
	public BikeServiceImpl(BikeDetailsRepository bikeRepo,UserProfileRepository userRepo, ModelMapper modelMapper) {
		this.bikeRepo = bikeRepo;
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public BikeDetailsDto getBikeDetails(String username) {
		// TODO Auto-generated method stub
		
		Optional<BikeDetailsEntity> bikeDetails = bikeRepo.findByUserProfileUsername(username);
		
		if (bikeDetails.isPresent()) {
			BikeDetailsDto bikeDetailsDto = modelMapper.map(bikeDetails.get(), BikeDetailsDto.class);
			return bikeDetailsDto;
		}
		return null;
	}

	@Override
	public void updateBikeDetails(String username, BikeDetailsDto details) {
		// TODO Auto-generated method stub
		UserProfileEntity user = userRepo.findByUsername(username)
		        .orElseThrow(() -> new RuntimeException("User not found"));

		if (user.getBikeDetails() == null) {
	        BikeDetailsEntity bikeDetailsEntity = modelMapper.map(details, BikeDetailsEntity.class);

	        bikeDetailsEntity.setUserProfile(user);    
	        user.setBikeDetails(bikeDetailsEntity); 
	    }	
		
		else {
			BikeDetailsEntity bikeDetailsEntity = user.getBikeDetails();
//			log.info("BikeDetails in Database : {}",bikeDetailsEntity.getKm_ridden());
//			log.info("BikeDetails Passed : {}",details);
			if(details.getBike_model() != null) {
				bikeDetailsEntity.setBike_model(details.getBike_model());
			}
			if(details.getBike_type() != null) {
				bikeDetailsEntity.setBike_type(details.getBike_type());
			}
			if(details.getKm_ridden() != null) {
				bikeDetailsEntity.setKm_ridden(details.getKm_ridden());
			}
		}
		userRepo.save(user);
	}
}