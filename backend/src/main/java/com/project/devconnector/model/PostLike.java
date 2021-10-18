package com.project.devconnector.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class PostLike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "post_id", nullable = false)
	 private Post post;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "likedByUser_id", nullable = false)
	 private User likedByUser;
	 public PostLike() {
			
		}

	public PostLike(Post post, User likedByUser) {
		
		this.post = post;
		this.likedByUser = likedByUser;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}



	public User getLikedByUser() {
		return likedByUser;
	}

	public void setLikedByUser(User likedByUser) {
		this.likedByUser = likedByUser;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	 
	 
	
}
