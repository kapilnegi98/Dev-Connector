package com.project.devconnector.payload;

import javax.persistence.Entity;


public class FollowerResponse {
	
	private Long id;
	private UserResponse user;
	public FollowerResponse(Long id, UserResponse user) {
		
		this.id = id;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserResponse getUser() {
		return user;
	}
	public void setUser(UserResponse user) {
		this.user = user;
	}
	
}
