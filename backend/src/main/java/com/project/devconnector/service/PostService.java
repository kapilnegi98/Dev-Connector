package com.project.devconnector.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.project.devconnector.exception.ResourceNotFoundException;
import com.project.devconnector.model.Comment;
import com.project.devconnector.model.Image;
import com.project.devconnector.model.Post;
import com.project.devconnector.model.PostLike;
import com.project.devconnector.model.User;
import com.project.devconnector.payload.CommentRequest;
import com.project.devconnector.payload.CommentResponse;
import com.project.devconnector.payload.LikeResponse;
import com.project.devconnector.payload.PostRequest;
import com.project.devconnector.payload.PostResponse;
import com.project.devconnector.payload.UserResponse;
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
	
	@Autowired
    private Cloudinary cloudinaryConfig;

    public String uploadFile(MultipartFile file) {
        try {
            File uploadedFile = convertMultiPartToFile(file);
            Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
            return  uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
	
	
	public PostResponse createPost(UserPrincipal currentUser, PostRequest postRequest) {
		System.out.println(postRequest);
		Post post = new Post(postRequest.getTitle(),postRequest.getDescription(),
				postRequest.getWebsiteUrl(),postRequest.getRepoUrl());
		
		User user = userRepository.findById(currentUser.getId()).orElseThrow();
		System.out.println(user);
	  post.setUser(user);
//	  String url = uploadFile(postRequest.getPostImage());
//	  System.out.println(url);
	  
	  
	 Post result = postRepository.save(post);
//	 Image newImage = new Image();
//	  newImage.setImageUrl(url);
//	  newImage.setPost(result);
//	  Image imageResponse = imageRepository.save(newImage);
	
	 PostResponse postResponse = getPostById(result.getId());
	 return postResponse;
	}
	public PostResponse getPostById(Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
//		List<Comment> comments = commentRepository.findCommentsByPostId(postId);
//		List<Like> likes = likeRepository.findLikesByPostId(postId);
//		List<TechTags> tags = techTagsRepository.findAll();
//		List<TechTags> tagsByPost = tags
//List<Like> likes = post.getLikes().stream().collect(Collectors.toList());
	
		List<PostLike> likes = postLikeRepository.findLikesByPostId(post.getId());
		List<LikeResponse> likeResponseList = likes.stream().map((res) -> new LikeResponse(res.getId(), new UserResponse(res.getLikedByUser().getId(), res.getLikedByUser().getName(),
				res.getLikedByUser().getEmail(), res.getLikedByUser().getAvatar())))
				.collect(Collectors.toList());
		List<Comment> comments = post.getComments().stream().collect(Collectors.toList());
		List<CommentResponse> commentResponse = comments.stream().map((comment) -> new CommentResponse(comment.getId(),
				comment.getText(),comment.getUser().getId(),comment.getUser().getName(),
				comment.getUser().getEmail(), comment.getCreatedAt())).collect(Collectors.toList());
		
		List<String> images = imageRepository.findByPostId(postId);
		List<String> tags = post.getTags().stream().map((tag) -> tag.getTag()).collect(Collectors.toList());
		User user = post.getUser();
		UserResponse userSummary = new UserResponse(user.getId(), user.getName(), user.getEmail(),user.getAvatar());
		
		PostResponse postResponse = new PostResponse(postId, post.getTitle(), 
				post.getDescription(), post.getWebsiteUrl(), post.getRepoUrl(), 
				commentResponse, images, likeResponseList, tags, userSummary,post.getCreatedAt());
				return postResponse;
		}
	public LikeResponse addLike(UserPrincipal currentUser, Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		User user = userRepository.findById(currentUser.getId()).orElseThrow();
		PostLike postLike = new PostLike(post, user);
		PostLike result = postLikeRepository.save(postLike);
		UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getAvatar());
		LikeResponse likeResponse = new LikeResponse(result.getId(),userResponse);
		return likeResponse;
	}
	public void removeLike(UserPrincipal currentUser, Long postId) {
		// TODO Auto-generated method stub
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		postLikeRepository.deleteByPostId(postId, currentUser.getId());
		
	}
	public List<CommentResponse> getAllCommentsOfPost(Post post) {
		List<Comment> comments = post.getComments().stream().collect(Collectors.toList());
		List<CommentResponse> commentResponse = comments.stream().map((comment) -> new CommentResponse(comment.getId(),
				comment.getText(),comment.getUser().getId(),comment.getUser().getName(),
				comment.getUser().getEmail(), comment.getCreatedAt())).collect(Collectors.toList());
	return commentResponse;
	}
	public List<CommentResponse> addComment(UserPrincipal currentUser, @Valid CommentRequest commentRequest, Long postId) {
		// TODO Auto-generated method stub
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		User user = userRepository.findById(currentUser.getId()).orElseThrow();
		Comment comment = new Comment(commentRequest.getText(), post, user);
		
		Comment result = commentRepository.save(comment);
		
		
		return getAllCommentsOfPost(post);
	}
	public void removeComment(Long commentId, Long postId) {
		Comment comment = commentRepository.findById(commentId).orElseThrow(
				() ->new ResourceNotFoundException("Comment", "id", commentId));
		commentRepository.deleteById(commentId);
		
	}
	public void deletePost(Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(() 
				-> new ResourceNotFoundException("Post", "id", postId));
		postRepository.deleteById(postId);
		
	}
	public List<PostResponse> getUserAllPosts(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		List<Post> posts = postRepository.findAllPostsByUserId(userId);
		List<PostResponse> postResponses = new ArrayList<>();
		for(Post post: posts) {
			postResponses.add(getPostById(post.getId()));
		}
		return postResponses;
	}
	public List<PostResponse> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		List<PostResponse> postResponses = new ArrayList<>();
		for(Post post: posts) {
			postResponses.add(getPostById(post.getId()));
		}
		return postResponses;
		
	}
	

}
