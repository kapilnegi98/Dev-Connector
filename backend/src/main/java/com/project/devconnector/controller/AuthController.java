package com.project.devconnector.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.devconnector.exception.AppException;
import com.project.devconnector.model.Role;
import com.project.devconnector.model.RoleName;
import com.project.devconnector.model.User;
import com.project.devconnector.payload.ApiResponse;
import com.project.devconnector.payload.JwtAuthenticationResponse;
import com.project.devconnector.payload.LoginRequest;
import com.project.devconnector.payload.SignUpRequest;
import com.project.devconnector.repository.RoleRepository;
import com.project.devconnector.repository.UserRepository;
import com.project.devconnector.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if(userRepository.existsByEmail(signUpRequest.getEmail())){
			return new ResponseEntity<>(new ApiResponse(false, "Email Already Exists"), HttpStatus.BAD_REQUEST);
		}
		User user = new User(signUpRequest.getName(),signUpRequest.getEmail(),signUpRequest.getPassword());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		
		Role userRole = roleRepository.getByRoleName(RoleName.ROLE_USER).orElseThrow(
				() -> new AppException("User Role not set"));
		user.setRoles(Collections.singleton(userRole));
		
		User result = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/users/{id}").buildAndExpand(result.getId()).toUri();
		
		return ResponseEntity.created(location)
				.body(new ApiResponse(true, "User Created Successfully"));
	}

}
