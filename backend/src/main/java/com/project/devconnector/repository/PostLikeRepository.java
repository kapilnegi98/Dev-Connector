package com.project.devconnector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.PostLike;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long>{

	@Query("select l from PostLike l where l.post.id= :postId")
	List<PostLike> findLikesByPostId(@Param("postId")Long postId);
	
	@Query("Delete from PostLike l where l.post.id= :postId and l.likedByUser.id= :userId")
	void deleteByPostId(@Param("postId") Long postId, @Param("userId") Long userId);
	
}
