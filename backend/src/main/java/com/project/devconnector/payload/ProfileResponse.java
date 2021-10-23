package com.project.devconnector.payload;

import java.time.Instant;
import java.util.List;

public class ProfileResponse {
	private Long id;
	private String bio;
	private String website;
	private String location;
	private String githubUsername;
	private SocialResponse social;
	private UserResponse user;
	private List<FollowerResponse> followers;
	private List<FollowingResponse> following;
	private List<String> skills;
		private Instant date;
	public ProfileResponse(Long id,String bio, String website, String location, String githubUsername, SocialResponse social,
			UserResponse user, List<FollowerResponse> followers, List<FollowingResponse> following,
			List<String> skills, Instant date) {
		this.id = id;
		this.bio = bio;
		this.website = website;
		this.location = location;
		this.githubUsername = githubUsername;
		this.social = social;
		this.user = user;
		this.followers = followers;
		this.following = following;
		this.skills = skills;
		this.date= date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public SocialResponse getSocial() {
		return social;
	}
	public void setSocial(SocialResponse social) {
		this.social = social;
	}
	public UserResponse getUserResponse() {
		return user;
	}
	public void setUserResponse(UserResponse userSummary) {
		this.user = userSummary;
	}
	public List<FollowerResponse> getFollowers() {
		return followers;
	}
	public void setFollowers(List<FollowerResponse> followers) {
		this.followers = followers;
	}
	public List<FollowingResponse> getFollowing() {
		return following;
	}
	public void setFollowing(List<FollowingResponse> following) {
		this.following = following;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public UserResponse getUser() {
		return user;
	}
	public void setUser(UserResponse user) {
		this.user = user;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	

	
}
