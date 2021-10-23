package com.project.devconnector.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Social {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String twitter;
	private String instagram;
	private String linkedin;
	private String codepen;
	private String github;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
	private Profile profile;
public Social() {
		
	}

	public Social(String twitter, String instagram, String linkedin, String codepen, String github) {
	
	this.twitter = twitter;
	this.instagram = instagram;
	this.linkedin = linkedin;
	this.codepen = codepen;
	this.github = github;
}

	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getCodepen() {
		return codepen;
	}
	public void setCodepen(String codepen) {
		this.codepen = codepen;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
	
}
