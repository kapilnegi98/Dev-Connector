package com.project.devconnector.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.devconnector.model.User;

public interface ProfileRepository extends JpaRepository<User, Long>{
	
}
