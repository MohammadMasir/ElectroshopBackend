package com.electroshop.electroshop_backend.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electroshop.electroshop_backend.domain.User;
import com.electroshop.electroshop_backend.dto.user.UserQuery;
import com.electroshop.electroshop_backend.security.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/login")
	public String generateSome(@RequestBody UserQuery user) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
					);
			
			return jwtUtil.generateToken();
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw e;
		}
	}
	
}
