package com.project.devconnector.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.devconnector.model.Post;
import com.project.devconnector.payload.ApiResponse;
import com.project.devconnector.payload.CommentRequest;
import com.project.devconnector.payload.LikeResponse;
import com.project.devconnector.payload.PostRequest;
import com.project.devconnector.payload.PostResponse;
import com.project.devconnector.security.CurrentUser;
import com.project.devconnector.security.UserPrincipal;
import com.project.devconnector.service.PostService;

@RestController
@RequestMapping("api/posts")
public class PostController {
	@Autowired
	private PostService postService;
	
	//Create new Post
	@PostMapping
	public ResponseEntity<?> createpost(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody PostRequest postRequest){
		System.out.println("inside cp");
		Post post = postService.createPost(currentUser, postRequest);
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/{post_id}")
				.buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).body(new ApiResponse(true, "post created successfully"));
	}
	
	//Get Post by IdO
	@GetMapping("/{postId}")
	public ResponseEntity<?> getPostById(@PathVariable Long postId){
		PostResponse post = postService.getPostById(postId);
		System.out.println(post);
		return ResponseEntity.ok(post);
	}
	@PutMapping("/like/{postId}")
	public ResponseEntity<?> addLike(@CurrentUser UserPrincipal currentUser, @PathVariable Long postId){
			LikeResponse response = postService.addLike(currentUser, postId);
			
		return ResponseEntity.ok(response);
	}
//	@DeleteMapping("${postId}")
//	public ResponseEntity<?> deletePost(@PathVariable Long postId){
//		
//	}
	@PutMapping("/like/{postId}")
	public ResponseEntity<?> removeLike(@CurrentUser UserPrincipal currentUser, @PathVariable Long postId){
		postService.removeLike(currentUser, postId);
		return ResponseEntity.ok(new ApiResponse(true, "deleted"));
	}
	@PostMapping("/comment/${postId}")
	public ResponseEntity<?> createComment(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody CommentRequest commentRequest, @PathVariable Long postId){
		
	}
//	@DeleteMapping("/comment/${postId}/${commentId}")
//	public ResponseEntity<?> deleteComment(@PathVariable Long postId, @PathVariable Long CommentId){
//		
//	}
	
	
}
