package com.project.devconnector.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.project.devconnector.model.audit.DateAudit;

@Entity
public class Comment extends DateAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String text;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "post_id", nullable = false)
	 private Post post;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "user_id", nullable = false)
	 private User user;

	public Comment() {
		
	}

	public Comment(String text, Post post, User user) {
		super();
		this.text = text;
		this.post = post;
		this.user = user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	 
}
