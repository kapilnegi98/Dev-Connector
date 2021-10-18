package com.project.devconnector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Social;
@Repository
public interface SocialRepository extends JpaRepository<Social, Long>{
	
}
