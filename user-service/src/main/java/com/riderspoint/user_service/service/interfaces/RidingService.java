package com.riderspoint.user_service.service.interfaces;

import com.riderspoint.user_service.DTO.RidingDetailsDto;

public interface RidingService {
	RidingDetailsDto getRidingDetails(String username);
	void addRidingDetails(String username, RidingDetailsDto details);
    void updateRidingDetails(String username, RidingDetailsDto details);
}
