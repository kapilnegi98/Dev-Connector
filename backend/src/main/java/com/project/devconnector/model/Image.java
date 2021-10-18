package com.project.devconnector.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imageUrl;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "post_id", nullable = false)
	 private Post post;
public Image() {
		
	}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

}
