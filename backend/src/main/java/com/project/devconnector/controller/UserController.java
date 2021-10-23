package com.project.devconnector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.devconnector.payload.UserResponse;
import com.project.devconnector.security.CurrentUser;
import com.project.devconnector.security.UserPrincipal;
import com.project.devconnector.service.UserService;

@RestController
@RequestMapping("api/auth")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping
	public ResponseEntity<?> getCurrentUser(@CurrentUser UserPrincipal currentUser){
		UserResponse userSummary = userService.getUser(currentUser);
		return ResponseEntity.ok(userSummary);
	}

}
