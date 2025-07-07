package com.electroshop.electroshop_backend.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electroshop.electroshop_backend.domain.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	
	public AuthenticationController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
					);
			return "successfully authenticated!";
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw e;
		}
	}
	
}
