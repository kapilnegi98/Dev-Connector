package com.project.devconnector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Skill;
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
	
	@Query("Select s.name from Skill s where s.profile.id= :profileId")
	List<String> findSkillsByProfileId(@Param("profileId")Long profileId);
	
}
