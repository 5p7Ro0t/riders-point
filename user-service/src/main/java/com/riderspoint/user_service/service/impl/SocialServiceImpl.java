package com.riderspoint.user_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.riderspoint.user_service.DTO.SocialDetailsDto;
import com.riderspoint.user_service.repository.SocialDetailsRepository;
import com.riderspoint.user_service.service.interfaces.SocialService;

@Service
public class SocialServiceImpl implements SocialService {

	private final SocialDetailsRepository socialRepo;
	private final ModelMapper modelMapper;
	public SocialServiceImpl(SocialDetailsRepository socialRepo, ModelMapper modelMapper) {
		this.socialRepo = socialRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public SocialDetailsDto getSocialDetails(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSocialDetails(String username, SocialDetailsDto socialDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSocialDetails(String username, SocialDetailsDto socialDetails) {
		// TODO Auto-generated method stub

	}

}
