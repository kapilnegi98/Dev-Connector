package com.project.devconnector.payload;

public class SocialResponse {
	
	private String twitter;
	private String instagram;
	private String linkedin;
	private String codepen;
	private String github;
	
	
	public SocialResponse(String twitter, String instagram, String linkedin, String codepen, String github) {
		
		this.twitter = twitter;
		this.instagram = instagram;
		this.linkedin = linkedin;
		this.codepen = codepen;
		this.github = github;
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
	
}
