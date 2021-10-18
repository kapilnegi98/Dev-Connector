package com.project.devconnector.payload;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PostRequest {
	
	private String title;
	private String description;
	private String websiteUrl;
	private String repoUrl;
	private String techTags;
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

	@Override
	public String toString() {
		return "PostRequest [title=" + title + ", description=" + description + ", websiteUrl=" + websiteUrl
				+ ", repoUrl=" + repoUrl + ", techTags=" + techTags + "]";
	}
	
}
