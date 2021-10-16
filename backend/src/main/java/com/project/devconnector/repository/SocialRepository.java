package com.project.devconnector.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.devconnector.model.User;

public interface SocialRepository extends JpaRepository<User, Long>{
	
}
