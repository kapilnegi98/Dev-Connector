package com.project.devconnector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.project.devconnector.model.TechTags;

@Repository
public interface TechTagsRepository extends JpaRepository<TechTags, Long>{

//	@Query(value = "select t from TechTags t where :postId IN t.post")
//	List<TechTags> findTagsByPostId(@Param("postId")Long postId);
//	
}
