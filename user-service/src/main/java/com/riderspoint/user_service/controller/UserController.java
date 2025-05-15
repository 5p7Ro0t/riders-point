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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

	@GetMapping("/me")
	public ResponseEntity<UserProfile> getUserProfile(@RequestHeader("Authorization") String authorization_token) {
		log.info("Authorization Token : {}", authorization_token);
		return new ResponseEntity<>(new UserProfile(), HttpStatus.OK);
	}
	
	@PostMapping("/profile")
	public ResponseEntity<String> createUserProfile(@RequestHeader("Authorization") String authorization_token,@RequestBody UserProfile profile){
		log.info("User Details : {}", profile);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@PutMapping("/profile")
	public ResponseEntity<UserProfile> updateUserProfile(@RequestHeader("Authorization") String authorization_token,@RequestBody UserProfile profile) {
		return new ResponseEntity<>(new UserProfile(), HttpStatus.OK);
	}
	
	@GetMapping("/profile/completion-status")
	public ResponseEntity<String> checkCompletionStatus(@RequestHeader("Authorization") String authorization_token){
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<UserProfile>> getRiders(@RequestHeader("Authorization") String authorization_token){
		return new ResponseEntity<>(new ArrayList<UserProfile>(), HttpStatus.OK);
	}
}
