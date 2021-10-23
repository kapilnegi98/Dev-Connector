package com.project.devconnector.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.devconnector.model.Follow;
import com.project.devconnector.payload.ApiResponse;
import com.project.devconnector.payload.ProfileRequest;
import com.project.devconnector.payload.ProfileResponse;
import com.project.devconnector.security.CurrentUser;
import com.project.devconnector.security.UserPrincipal;
import com.project.devconnector.service.ProfileService;

@RestController
@RequestMapping("api/profile")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@PostMapping
	public ResponseEntity<?> createProfile(@CurrentUser UserPrincipal currentUser,@Valid @RequestBody ProfileRequest profileRequest) {
		ProfileResponse profileResponse = profileService.createProfile(currentUser, profileRequest);
	URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}")
			.buildAndExpand(profileResponse.getId()).toUri();
	return ResponseEntity.created(location).body(profileResponse);
	}
	@GetMapping("/me")
	public ResponseEntity<?> currentProfile(@CurrentUser UserPrincipal currentUser) {
		ProfileResponse profileResponse = profileService.getProfileByUserId(currentUser.getId());
		return ResponseEntity.ok(profileResponse);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> profileByUserId(@PathVariable Long userId) {
		ProfileResponse profileResponse = profileService.getProfileByUserId(userId);
		return ResponseEntity.ok(profileResponse);
	}
	@GetMapping
	public ResponseEntity<?> allProfiles() {
		List<ProfileResponse> profileResponses = profileService.getAllProfiles();
		return ResponseEntity.ok(profileResponses);
	}
	@PutMapping("/follow/{profileId}")
	public ResponseEntity<?> addFollow(@CurrentUser UserPrincipal currentUser, @PathVariable Long profileId){
		Follow followResponse = profileService.followProfile(currentUser, profileId);
		return ResponseEntity.ok(followResponse);
	}
	@PutMapping("/unfollow/{profileId}")
	public ResponseEntity<?> unfollow(@CurrentUser UserPrincipal currentUser, @PathVariable Long profileId){
		profileService.unfollowProfile(currentUser, profileId);
		return ResponseEntity.ok(new ApiResponse(true, "unfollowed"));
	}
	}
