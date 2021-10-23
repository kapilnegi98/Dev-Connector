package com.project.devconnector.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.devconnector.payload.ApiResponse;
import com.project.devconnector.payload.CommentRequest;
import com.project.devconnector.payload.CommentResponse;
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
	public ResponseEntity<?> createpost(@CurrentUser UserPrincipal currentUser, @RequestParam("postImage") MultipartFile file,
			@RequestParam String title,@RequestParam String description, @RequestParam String techTags, @RequestParam String websiteUrl, @RequestParam String repoUrl){
		System.out.println("hhhh*********");
		System.out.println(file);
		PostRequest postRequest = new PostRequest(title, description, websiteUrl, repoUrl, techTags, file);
//		String url = postService.uploadFile(file);
//		System.out.println(url);
        
	
		PostResponse postResponse = postService.createPost(currentUser, postRequest);
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/{post_id}")
				.buildAndExpand(postResponse.getId()).toUri();
		return ResponseEntity.created(location).body(postResponse);
		
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
	@DeleteMapping("{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Long postId){
		postService.deletePost(postId);
		return ResponseEntity.ok(new ApiResponse(true, "deleted"));
	}
	@PutMapping("/unlike/{postId}")
	public ResponseEntity<?> removeLike(@CurrentUser UserPrincipal currentUser, @PathVariable Long postId){
		postService.removeLike(currentUser, postId);
		return ResponseEntity.ok(new ApiResponse(true, "deleted"));
	}
	@PostMapping("/comment/{postId}")
	public ResponseEntity<?> createComment(@CurrentUser UserPrincipal currentUser,@RequestBody CommentRequest commentRequest, @PathVariable Long postId){
		List<CommentResponse> commentResponse = postService.addComment(currentUser,commentRequest, postId);
		return ResponseEntity.ok(commentResponse);
	}
	@DeleteMapping("/comment/{postId}/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable Long postId, @PathVariable Long commentId){
		postService.removeComment(commentId,postId);
		return ResponseEntity.ok(new ApiResponse(true, "deleted"));
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> userAllPosts(@PathVariable Long userId){
		List<PostResponse> postResponses = postService.getUserAllPosts(userId);
		return ResponseEntity.ok(postResponses);
	}
	@GetMapping
	public ResponseEntity<?> allPosts(){
		List<PostResponse> postResponses = postService.getAllPosts();
		return ResponseEntity.ok(postResponses);
	}
	
	
}
