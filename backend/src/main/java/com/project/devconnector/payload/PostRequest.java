package com.project.devconnector.payload;

import org.springframework.web.multipart.MultipartFile;

public class PostRequest {
	
	private String title;
	private String description;
	private String websiteUrl;
	private String repoUrl;
	private String techTags;
	public MultipartFile postImage;
	
	public PostRequest(String title, String description, String websiteUrl, String repoUrl, String techTags,
			MultipartFile postImage) {
		
		this.title = title;
		this.description = description;
		this.websiteUrl = websiteUrl;
		this.repoUrl = repoUrl;
		this.techTags = techTags;
		this.postImage = postImage;
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

	public String getTechTags() {
		return techTags;
	}

	public void setTechTags(String techTags) {
		this.techTags = techTags;
	}
	



	public MultipartFile getPostImage() {
		return postImage;
	}

	public void setPostImage(MultipartFile postImage) {
		this.postImage = postImage;
	}

	@Override
	public String toString() {
		return "PostRequest [title=" + title + ", description=" + description + ", websiteUrl=" + websiteUrl
				+ ", repoUrl=" + repoUrl + ", techTags=" + techTags + "]";
	}
	
}
