package com.project.devconnector.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TechTags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tag;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "tags")
	private Set<Post> posts = new HashSet<>();
public TechTags() {
		
	}
public Long getId() {
	return id;
}

public String getTag() {
	return tag;
}
public void setTag(String tag) {
	this.tag = tag;
}
public Set<Post> getPosts() {
	return posts;
}
public void setPosts(Set<Post> posts) {
	this.posts = posts;
}

}
