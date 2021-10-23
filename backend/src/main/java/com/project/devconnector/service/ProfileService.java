package com.project.devconnector.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.devconnector.exception.ResourceNotFoundException;
import com.project.devconnector.model.Follow;
import com.project.devconnector.model.Profile;
import com.project.devconnector.model.Social;
import com.project.devconnector.model.User;
import com.project.devconnector.payload.FollowerResponse;
import com.project.devconnector.payload.FollowingResponse;
import com.project.devconnector.payload.ProfileRequest;
import com.project.devconnector.payload.ProfileResponse;
import com.project.devconnector.payload.SocialResponse;
import com.project.devconnector.payload.UserResponse;
import com.project.devconnector.repository.CommentRepository;
import com.project.devconnector.repository.FollowRepository;
import com.project.devconnector.repository.PostLikeRepository;
import com.project.devconnector.repository.PostRepository;
import com.project.devconnector.repository.ProfileRepository;
import com.project.devconnector.repository.SkillRepository;
import com.project.devconnector.repository.SocialRepository;
import com.project.devconnector.repository.UserRepository;
import com.project.devconnector.security.UserPrincipal;

@Service
public class ProfileService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostLikeRepository postLikeRepository;
	@Autowired
	private SocialRepository socialRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private FollowRepository followRepository;
	@Autowired
	private SkillRepository skillRepository;

	public ProfileResponse createProfile(UserPrincipal currentUser, ProfileRequest profileRequest) {
		
		User user = userRepository.findById(currentUser.getId()).get();
		
		Profile profile = new Profile(profileRequest.getBio(), profileRequest.getWebsite(),
				profileRequest.getLocation(), profileRequest.getGithubUsername());
		profile.setUser(user);
		
		
		
		Profile result = profileRepository.save(profile);
		Social social = new Social(profileRequest.getTwitter(), profileRequest.getInstagram(),
				profileRequest.getLinkedin(), profileRequest.getCodepen(), profileRequest.getGithub());
		social.setProfile(result);
		socialRepository.save(social);
		ProfileResponse response = getProfileByUserId(result.getUser().getId());
		
		return response;
	}

	public ProfileResponse getProfileByUserId(Long userId) {
		// get User
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		// get profile
		Profile profile = profileRepository.findByUserId(userId);

		// create Social Response
		Social social = socialRepository.findById(profile.getSocial().getId()).get();
		SocialResponse socialResponse = new SocialResponse(social.getTwitter(), social.getInstagram(),
				social.getLinkedin(), social.getCodepen(), social.getGithub());

		// following
		List<Follow> following = followRepository.findFollowing(userId);

		List<FollowingResponse> followingList = following.stream()
				.map((follow) -> new FollowingResponse(follow.getId(), follow.getFollowing()))
				.collect(Collectors.toList());

		// followers
		List<Follow> followers = followRepository.findFollowers(userId);
		List<FollowerResponse> followersList = followers.stream()
				.map((follow) -> {
					User userTemp = userRepository.findById(follow.getUserId()).get();
					
					return new FollowerResponse(follow.getId(), new UserResponse(userTemp.getId(), user.getName(), userTemp.getEmail(), userTemp.getAvatar()));
					}).collect(Collectors.toList());
				

		List<String> skills = skillRepository.findSkillsByProfileId(profile.getId());
		System.out.println(profile.getCreatedAt());
		UserResponse userSummary = new UserResponse(user.getId(), user.getName(), user.getEmail(),user.getAvatar());
		ProfileResponse profileResponse = new ProfileResponse(profile.getId(), profile.getBio(), profile.getWebsite(), profile.getLocation()
				, profile.getGithubUsername(), socialResponse, userSummary, 
				followersList, followingList, skills,profile.getCreatedAt());
		return profileResponse;
	}

	public List<ProfileResponse> getAllProfiles() {
		// TODO Auto-generated method stub
		List<Profile> profiles = profileRepository.findAll();
		List<ProfileResponse> profileResponses = new ArrayList<>();
		for(Profile p: profiles) {
			profileResponses.add(getProfileByUserId(p.getUser().getId()));
		}
		return profileResponses;
	}

	public Follow followProfile(UserPrincipal currentUser, Long profileId) {
		Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("profile", "id", profileId));

		Follow follow = new Follow();
		follow.setUserId(currentUser.getId());
		follow.setFollowing(profile.getUser().getId());
		Follow response = followRepository.save(follow);
		return response;
	}

	public void unfollowProfile(UserPrincipal currentUser, Long profileId) {
		// TODO Auto-generated method stub
		Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("profile", "id", profileId));
		Follow follow = followRepository.getByUserdIdAndFollowingIf(currentUser.getId(), profile.getUser().getId());
		followRepository.deleteById(follow.getId());
		
	}

}
