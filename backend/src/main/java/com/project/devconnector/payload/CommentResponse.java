package com.project.devconnector.payload;

import java.time.Instant;

public class CommentResponse {
	
	private Long id;
	private String text;
	private Long userId;
	private String name;
	private String email;
	private Instant date;
	
	public CommentResponse(Long id, String text, Long userId, String name, String email, Instant date) {
	
		this.id = id;
		this.text = text;
		this.userId = userId;
		this.name = name;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}

}
