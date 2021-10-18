package com.project.devconnector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
}
