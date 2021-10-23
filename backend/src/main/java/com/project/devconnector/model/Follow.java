package com.project.devconnector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long userId;
	private Long following;
public Follow() {
		
	}



public Long getUserId() {
	return userId;
}



public void setUserId(Long userId) {
	this.userId = userId;
}



public Long getFollowing() {
	return following;
}

public void setFollowing(Long following) {
	this.following = following;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

}
