package com.project.devconnector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
}
