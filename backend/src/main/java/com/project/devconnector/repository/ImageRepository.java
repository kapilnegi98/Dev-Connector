package com.project.devconnector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

	@Query("Select i.imageUrl from Image i where i.post.id= :postId")
	List<String> findByPostId(@Param("postId") Long postId);

}
