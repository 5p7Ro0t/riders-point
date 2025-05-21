package com.riderspoint.user_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.riderspoint.user_service.DTO.SocialDetailsDto;
import com.riderspoint.user_service.entity.SocialDetailsEntity;
import com.riderspoint.user_service.entity.UserProfileEntity;
import com.riderspoint.user_service.repository.UserProfileRepository;
import com.riderspoint.user_service.service.interfaces.SocialService;

@Service
public class SocialServiceImpl implements SocialService {

	private final UserProfileRepository userRepo;
	private final ModelMapper modelMapper;
	
	

	public SocialServiceImpl(UserProfileRepository userRepo, ModelMapper modelMapper) {
		super();
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public SocialDetailsDto getSocialDetails(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSocialDetails(String username, SocialDetailsDto socialDetails) {
		// TODO Auto-generated method stub
		UserProfileEntity user = userRepo.findByUsername(username)
				.orElseThrow(() ->  new RuntimeException("User Not Found"));
		if(user.getSocialDetails() == null) {
			SocialDetailsEntity socialDetailsEntity = modelMapper.map(socialDetails, SocialDetailsEntity.class);
			socialDetailsEntity.setUserProfile(user);
			user.setSocialDetails(socialDetailsEntity);
		}
		else {
			SocialDetailsEntity socialDetailsEntity = user.getSocialDetails();
			if(socialDetails.getInstagram_url() != null) {
				socialDetailsEntity.setInstagram_url(socialDetails.getInstagram_url());
			}
			if(socialDetails.getLinkedin_url() != null) {
				socialDetailsEntity.setLinkedin_url(socialDetails.getLinkedin_url());
			}
			if(socialDetails.getYoutube_url() != null) {
				socialDetailsEntity.setYoutube_url(socialDetails.getYoutube_url());
			}
		}
		userRepo.save(user);
	}
}
