package com.riderspoint.user_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.riderspoint.user_service.DTO.BikeDetailsDto;
import com.riderspoint.user_service.repository.BikeDetailsRepository;
import com.riderspoint.user_service.service.interfaces.BikeService;

@Service
public class BikeServiceImpl implements BikeService {

	private final BikeDetailsRepository bikeRepo;
	private final ModelMapper modelMapper;
	
	public BikeServiceImpl(BikeDetailsRepository bikeRepo, ModelMapper modelMapper) {
		this.bikeRepo = bikeRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public BikeDetailsDto getBikeDetails(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBikeDetails(String username, BikeDetailsDto details) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBikeDetails(String username, BikeDetailsDto details) {
		// TODO Auto-generated method stub

	}

}
