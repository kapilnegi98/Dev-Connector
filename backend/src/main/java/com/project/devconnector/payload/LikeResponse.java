package com.project.devconnector.payload;

public class LikeResponse {
	
	private Long id;
	private UserResponse user;
	public LikeResponse(Long id, UserResponse user) {
		
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
