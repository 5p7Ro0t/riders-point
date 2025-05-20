package com.riderspoint.user_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riderspoint.user_service.DTO.BikeDetailsDto;
import com.riderspoint.user_service.DTO.RidingDetailsDto;
import com.riderspoint.user_service.DTO.UserProfileDto;
import com.riderspoint.user_service.pojo.BikeDetails;
import com.riderspoint.user_service.pojo.RidingDetails;
import com.riderspoint.user_service.pojo.SocialDetails;
import com.riderspoint.user_service.pojo.UserProfile;
import com.riderspoint.user_service.service.impl.BikeServiceImpl;
import com.riderspoint.user_service.service.impl.RidingServiceImpl;
import com.riderspoint.user_service.service.impl.SocialServiceImpl;
import com.riderspoint.user_service.service.impl.UserServiceImpl;
import com.riderspoint.user_service.service.interfaces.BikeService;
import com.riderspoint.user_service.service.interfaces.RidingService;
import com.riderspoint.user_service.service.interfaces.SocialService;
import com.riderspoint.user_service.service.interfaces.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private final ModelMapper modelMapper;
	private final UserService userService;
	private final BikeService bikeService;
	private final RidingService ridingService;
	private final SocialService socialService;
	
	
	public UserController(ModelMapper modelMapper, UserServiceImpl userService, BikeServiceImpl bikeService, RidingServiceImpl ridingService, SocialServiceImpl socialService) {
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.bikeService = bikeService;
		this.socialService = socialService;
		this.ridingService = ridingService;
	}
	
	@GetMapping("/me")
	public ResponseEntity<UserProfile> getUserProfile(@RequestHeader("Authorization") String authToken) {
		
		UserProfileDto userProfileDto = userService.getUserProfile(authToken);
		
		UserProfile profile = modelMapper.map(userProfileDto, UserProfile.class);
		log.info("Authorization Token : {}", authToken);
		return new ResponseEntity<>(profile, HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> createUserProfile(@RequestHeader("Authorization") String authToken,@RequestBody UserProfile profile){
		
		UserProfileDto userProfile = modelMapper.map(profile, UserProfileDto.class);
		userService.createUserProfile(profile.getUsername(), userProfile);
		log.info("User Details : {}", profile);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
	}
	
	@PostMapping("/profile/riding-details")
	public ResponseEntity<String> addRidingDetails(@RequestHeader("Authorization") String authToken, @RequestBody RidingDetails ridingDetails) {
		RidingDetailsDto ridingDetailsDto = modelMapper.map(ridingDetails, RidingDetailsDto.class);
		ridingService.updateRidingDetails(authToken, ridingDetailsDto);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}
	
	@PostMapping("/profile/bike-details")
	public ResponseEntity<String> addBikeDetails(@RequestHeader("Authorization") String authToken, @RequestBody BikeDetails bikeDetails) {
		BikeDetailsDto bikeDetailsDto = modelMapper.map(bikeDetails, BikeDetailsDto.class);
		bikeService.updateBikeDetails(authToken, bikeDetailsDto);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}
	
	@PostMapping("/profile/social-details")
	public void addSocialDetails(@RequestHeader("Authorization") String authToken, @RequestBody SocialDetails socialDetails) {
		
	}
	
	@PutMapping("/profile/basics")
	public ResponseEntity<String> updateBasicProfile(@RequestHeader("Authorization") String authToken,@RequestBody UserProfile profile) {
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@GetMapping("/profile/completion-status")
	public ResponseEntity<String> checkCompletionStatus(@RequestHeader("Authorization") String authToken){
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<UserProfile>> getRiders(@RequestHeader("Authorization") String authToken){
		return new ResponseEntity<>(new ArrayList<UserProfile>(), HttpStatus.OK);
	}
	
	
	
	@PutMapping("/profile/status/emergency-responder")
	public ResponseEntity<String> updateEmergencyResponderStatus(@RequestHeader("Authorization") String authToken) {
	    
	    return ResponseEntity.ok("Emergency responder status updated");
	}
}
