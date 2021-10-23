package com.project.devconnector.payload;

import java.time.Instant;
import java.util.List;

public class PostResponse {
	private Long id;
	private String title;
	private String description;
	private String websiteUrl;
	private String repoUrl;
	private List<CommentResponse> comments;
	private List<String> images;
	private List<LikeResponse> likes;
	private List<String> techTags;
	private UserResponse user;
	private Instant date;
	
	
	public PostResponse(Long id, String title, String description, String websiteUrl, String repoUrl,
			List<CommentResponse> comments, List<String> images, List<LikeResponse> likes, List<String> techTags,
			UserResponse user, Instant date) {
	
		this.id = id;
		this.title = title;
		this.description = description;
		this.websiteUrl = websiteUrl;
		this.repoUrl = repoUrl;
		this.comments = comments;
		this.images = images;
		this.likes = likes;
		this.techTags = techTags;
		this.user = user;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getRepoUrl() {
		return repoUrl;
	}

	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}

	public List<CommentResponse> getComments() {
		return comments;
	}

	public void setComments(List<CommentResponse> comments) {
		this.comments = comments;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<LikeResponse> getLikes() {
		return likes;
	}

	public void setLikes(List<LikeResponse> likes) {
		this.likes = likes;
	}

	public List<String> getTechTags() {
		return techTags;
	}

	public void setTechTags(List<String> techTags) {
		this.techTags = techTags;
	}

	public UserResponse getUserResponse() {
		return user;
	}

	public void setUserResponse(UserResponse user) {
		this.user = user;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	
}
