package com.project.devconnector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	@Query("Select p from Post p where p.user.id= :userId")
	List<Post> findAllPostsByUserId(@Param("userId") Long userId);
	
}
