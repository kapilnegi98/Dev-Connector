package com.project.devconnector.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "profile_id", nullable = false)
	 private Profile profile;
	 
	public Skill() {
		
	}
	public Skill(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
