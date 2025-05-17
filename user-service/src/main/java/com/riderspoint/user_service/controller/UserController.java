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

import com.riderspoint.user_service.pojo.BasicProfile;
import com.riderspoint.user_service.pojo.BikeDetails;
import com.riderspoint.user_service.pojo.RidingDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

	@GetMapping("/me")
	public ResponseEntity<BasicProfile> getUserProfile(@RequestHeader("Authorization") String authorization_token) {
		log.info("Authorization Token : {}", authorization_token);
		return new ResponseEntity<>(BasicProfile.builder().build(), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> createUserProfile(@RequestHeader("Authorization") String authorization_token,@RequestBody BasicProfile profile){
		log.info("User Details : {}", profile);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@PostMapping("/profile/riding-details")
	public void addRidingDetails(@RequestHeader("Authorization") String authorization_token, @RequestBody RidingDetails ridingDetails) {
		
	}
	
	@PostMapping("/profile/bike-details")
	public void addBikeDetails(@RequestHeader("Authorization") String authorization_token, @RequestBody BikeDetails bikeDetails) {
		
	}
	
	public void addAboutMe(@RequestHeader("Authorization") String authorization_token) {
		
	}
	
	@PutMapping("/profile/basics")
	public ResponseEntity<BasicProfile> updateBasicProfile(@RequestHeader("Authorization") String authorization_token,@RequestBody BasicProfile profile) {
		return new ResponseEntity<>(BasicProfile.builder().build(), HttpStatus.OK);
	}
	
	@PutMapping("/profile/riding-details")
	public void updateRidingDetails(@RequestHeader("Authorization") String authorization_token, @RequestBody RidingDetails ridingDetails) {
		
	}
	
	@PutMapping("/profile/bike-details")
	public void updateBikeDetails(@RequestHeader("Authorization") String authorization_token, @RequestBody BikeDetails bikeDetails) {
		
	}
	
	@GetMapping("/profile/completion-status")
	public ResponseEntity<String> checkCompletionStatus(@RequestHeader("Authorization") String authorization_token){
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<BasicProfile>> getRiders(@RequestHeader("Authorization") String authToken){
		return new ResponseEntity<>(new ArrayList<BasicProfile>(), HttpStatus.OK);
	}
	
	
	
	@PutMapping("/profile/status/emergency-responder")
	public ResponseEntity<String> updateEmergencyResponderStatus(@RequestHeader("Authorization") String authToken) {
	    
	    return ResponseEntity.ok("Emergency responder status updated");
	}
}
