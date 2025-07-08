package com.electroshop.electroshop_backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.electroshop.electroshop_backend.dto.user.UserQuery;
import com.electroshop.electroshop_backend.repository.UserRepository;
import com.electroshop.electroshop_backend.security.JwtUtil;

@Service
public class AuthenticationService {

	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	
	public AuthenticationService(UserRepository userRepository, JwtUtil jwtUtil, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
	}
	
	public String login(UserQuery user) {
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.phoneNumber(), user.password())
				);
		
		return jwtUtil.generateToken();
		
	} catch (AuthenticationException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		return "";
		}
	}
	
	public Boolean signup() {
		return true;
	}
	
}

