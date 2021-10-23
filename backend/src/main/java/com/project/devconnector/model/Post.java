package com.project.devconnector.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.project.devconnector.model.audit.DateAudit;

@Entity
public class Post extends DateAudit{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String websiteUrl;
	private String repoUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "post")
	private Set<Comment> comments = new HashSet<>();
	
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "post")
	private Set<PostLike> postLikes = new HashSet<>();
		
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "post")
	private Set<Image> images = new HashSet<>();
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "post_tags",
	            joinColumns = @JoinColumn(name = "post_id"),
	            inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<TechTags> tags = new HashSet<>();
	 public Post() {
			
		}
	public Post(String title, String description, String websiteUrl, String repoUrl) {
		
		this.title = title;
		this.description = description;
		this.websiteUrl = websiteUrl;
		this.repoUrl = repoUrl;
	}
	
	public Long getId() {
		return id;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<PostLike> getPostLikes() {
		return postLikes;
	}
	public void setPostLikes(Set<PostLike> postLikes) {
		this.postLikes = postLikes;
	}
	public Set<TechTags> getTags() {
		return tags;
	}
	public void setTags(Set<TechTags> tags) {
		this.tags = tags;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Image> getImages() {
		return images;
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", websiteUrl=" + websiteUrl
				+ ", repoUrl=" + repoUrl + ", user=" + user + ", tags=" + tags + "]";
	}
	
	
}
