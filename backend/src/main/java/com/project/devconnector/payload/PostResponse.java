package com.project.devconnector.payload;

import java.util.List;

import com.project.devconnector.model.Comment;
import com.project.devconnector.model.Image;
import com.project.devconnector.model.Like;
import com.project.devconnector.model.TechTags;
import com.project.devconnector.model.User;

public class PostResponse {
	private Long postId;
	private String title;
	private String description;
	private String websiteUrl;
	private String repoUrl;
	private List<CommentResponse> comments;
	private List<String> images;
	private List<Like> likes;
	private List<String> techTags;
	private UserSummary userSummary;
	
	public PostResponse() {
		
	}
	
	public PostResponse(Long postId, String title, String description, String websiteUrl, String repoUrl,
			List<CommentResponse> comments, List<String> images, List<Like> likes, List<String> techTags,
			UserSummary userSummary) {
		
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.websiteUrl = websiteUrl;
		this.repoUrl = repoUrl;
		this.comments = comments;
		this.images = images;
		this.likes = likes;
		this.techTags = techTags;
		this.userSummary = userSummary;
	}

	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
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

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<String> getTechTags() {
		return techTags;
	}

	public void setTechTags(List<String> techTags) {
		this.techTags = techTags;
	}

	public UserSummary getUserSummary() {
		return userSummary;
	}

	public void setUserSummary(UserSummary userSummary) {
		this.userSummary = userSummary;
	}

	
}
