package com.project.devconnector.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.project.devconnector.model.audit.DateAudit;

@Entity
public class Profile extends DateAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bio;
	private String website;
	private String location;
	private String githubUsername;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "profile")
	private Social social;
public Profile() {
		
	}

	public Profile(String bio, String website, String location, String githubUsername) {
	
	this.bio = bio;
	this.website = website;
	this.location = location;
	this.githubUsername = githubUsername;
}

	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGithubUsername() {
		return githubUsername;
	}
	public void setGithubUsername(String githubUsername) {
		this.githubUsername = githubUsername;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Social getSocial() {
		return social;
	}

	public void setSocial(Social social) {
		this.social = social;
	}
	
	
	
}
