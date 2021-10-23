package com.project.devconnector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.devconnector.model.User;
import com.project.devconnector.payload.UserResponse;
import com.project.devconnector.repository.UserRepository;
import com.project.devconnector.security.UserPrincipal;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserResponse getUser(UserPrincipal currentUser) {
		User user = userRepository.findById(currentUser.getId()).get();
		UserResponse userSummary = new UserResponse(user.getId(), user.getName(), user.getEmail(),user.getAvatar());
		return userSummary;
	}
}
