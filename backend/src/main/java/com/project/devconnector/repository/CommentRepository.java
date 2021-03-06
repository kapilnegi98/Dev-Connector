package com.project.devconnector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Comment;
import com.project.devconnector.model.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query("select c from Comment c where c.post.id= :postId")
	List<Comment> findCommentsByPostId(@Param("postId") Long postId);
	
}
