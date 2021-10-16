package com.project.devconnector.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Comment {
	 private Long id;
	 private String text;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "post_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 private Post post;
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "user_id", nullable = false)
	 private User user;

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
