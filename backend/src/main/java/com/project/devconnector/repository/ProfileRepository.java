package com.project.devconnector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{

	@Query("Select p from Profile p where p.user.id= :userId")
	Profile findByUserId(@Param("userId") Long userId);
	
}
