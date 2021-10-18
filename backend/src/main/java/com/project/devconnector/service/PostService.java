package com.project.devconnector.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.devconnector.exception.ResourceNotFoundException;
import com.project.devconnector.model.Comment;
import com.project.devconnector.model.Post;
import com.project.devconnector.model.PostLike;
import com.project.devconnector.model.User;
import com.project.devconnector.payload.CommentResponse;
import com.project.devconnector.payload.LikeResponse;
import com.project.devconnector.payload.PostRequest;
import com.project.devconnector.payload.PostResponse;
import com.project.devconnector.payload.UserSummary;
import com.project.devconnector.repository.CommentRepository;
import com.project.devconnector.repository.ImageRepository;
import com.project.devconnector.repository.PostLikeRepository;
import com.project.devconnector.repository.PostRepository;
import com.project.devconnector.repository.TechTagsRepository;
import com.project.devconnector.repository.UserRepository;
import com.project.devconnector.security.UserPrincipal;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostLikeRepository postLikeRepository;
	@Autowired
	private TechTagsRepository techTagsRepository;
	@Autowired
	private ImageRepository imageRepository;
	public Post createPost(UserPrincipal currentUser, PostRequest postRequest) {
		System.out.println(postRequest);
		Post post = new Post(postRequest.getTitle(),postRequest.getDescription(),
				postRequest.getWebsiteUrl(),postRequest.getRepoUrl());
		System.out.println(post);
		System.out.println("--------");
		System.out.println(currentUser);
		System.out.println("--------");
		User user = userRepository.findById(currentUser.getId()).orElseThrow();
		System.out.println(user);
	  post.setUser(user);
		
	return postRepository.save(post);
	}
	public PostResponse getPostById(Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
//		List<Comment> comments = commentRepository.findCommentsByPostId(postId);
//		List<Like> likes = likeRepository.findLikesByPostId(postId);
//		List<TechTags> tags = techTagsRepository.findAll();
//		List<TechTags> tagsByPost = tags
//List<Like> likes = post.getLikes().stream().collect(Collectors.toList());
	
		List<PostLike> likes = new ArrayList<>();
		List<Comment> comments = post.getComments().stream().collect(Collectors.toList());
		List<CommentResponse> commentResponse = comments.stream().map((comment) -> new CommentResponse(comment.getId(),
				comment.getText(),comment.getUser().getId(),comment.getUser().getName(),
				comment.getUser().getEmail())).collect(Collectors.toList());
		
		List<String> images = imageRepository.findByPostId(postId);
		List<String> tags = post.getTags().stream().map((tag) -> tag.getTag()).collect(Collectors.toList());
		User user = post.getUser();
		UserSummary userSummary = new UserSummary(user.getId(), user.getName(), user.getEmail());
		PostResponse postResponse = new PostResponse(postId, post.getTitle(), 
				post.getDescription(), post.getWebsiteUrl(), post.getRepoUrl(), 
				commentResponse, images, likes, tags, userSummary);
				return postResponse;
		}
	public LikeResponse addLike(UserPrincipal currentUser, Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		User user = userRepository.findById(currentUser.getId()).orElseThrow();
		PostLike postLike = new PostLike(post, user);
		PostLike result = postLikeRepository.save(postLike);
		LikeResponse likeResponse = new LikeResponse(result.getId(),user.getId());
		return likeResponse;
	}
	public void removeLike(UserPrincipal currentUser, Long postId) {
		// TODO Auto-generated method stub
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		postLikeRepository.deleteByPostId(postId, currentUser.getId());
		
	}

}
