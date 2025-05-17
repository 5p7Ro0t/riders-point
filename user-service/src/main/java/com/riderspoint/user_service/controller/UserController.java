package com.riderspoint.user_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riderspoint.user_service.pojo.UserProfile;
import com.riderspoint.user_service.pojo.BikeDetails;
import com.riderspoint.user_service.pojo.RidingDetails;
import com.riderspoint.user_service.pojo.SocialDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

	@GetMapping("/me")
	public ResponseEntity<UserProfile> getUserProfile(@RequestHeader("Authorization") String authToken) {
		log.info("Authorization Token : {}", authToken);
		return new ResponseEntity<>(UserProfile.builder().build(), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> createUserProfile(@RequestHeader("Authorization") String authToken,@RequestBody UserProfile profile){
		
		log.info("User Details : {}", profile);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@PostMapping("/profile/riding-details")
	public void addRidingDetails(@RequestHeader("Authorization") String authToken, @RequestBody RidingDetails ridingDetails) {
		
	}
	
	@PostMapping("/profile/bike-details")
	public void addBikeDetails(@RequestHeader("Authorization") String authToken, @RequestBody BikeDetails bikeDetails) {
		
	}
	
	@PostMapping("/profile/social-details")
	public void addSocialDetails(@RequestHeader("Authorization") String authToken, @RequestBody SocialDetails socialDetails) {
		
	}
	
	@PutMapping("/profile/basics")
	public ResponseEntity<UserProfile> updateBasicProfile(@RequestHeader("Authorization") String authToken,@RequestBody UserProfile profile) {
		return new ResponseEntity<>(UserProfile.builder().build(), HttpStatus.OK);
	}
	
	@PutMapping("/profile/riding-details")
	public void updateRidingDetails(@RequestHeader("Authorization") String authToken, @RequestBody RidingDetails ridingDetails) {
		
	}
	
	@PutMapping("/profile/bike-details")
	public void updateBikeDetails(@RequestHeader("Authorization") String authToken, @RequestBody BikeDetails bikeDetails) {
		
	}
	
	@PutMapping("/profile/social-details")
	public void updateSocialDetails(@RequestHeader("Authorization") String authToken, @RequestBody SocialDetails socialDetails) {
		
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
