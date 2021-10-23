package com.project.devconnector.payload;

public class FollowingResponse {
	private Long id;
	private Long user;
	public FollowingResponse(Long id, Long user) {
		
		this.id = id;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	
}
