package com.riderspoint.user_service.service.interfaces;

import com.riderspoint.user_service.DTO.BikeDetailsDto;

public interface BikeService {
	BikeDetailsDto getBikeDetails(String username);
	void updateBikeDetails(String username, BikeDetailsDto details);
}
