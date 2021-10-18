package com.project.devconnector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Follower {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
public Follower() {
		
	}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

}
