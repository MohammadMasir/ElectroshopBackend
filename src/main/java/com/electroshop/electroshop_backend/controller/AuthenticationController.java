package com.electroshop.electroshop_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electroshop.electroshop_backend.domain.User;
import com.electroshop.electroshop_backend.dto.user.NewUser;
import com.electroshop.electroshop_backend.dto.user.UserQuery;
import com.electroshop.electroshop_backend.service.AuthenticationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/electroshop")
public class AuthenticationController {
	
	private AuthenticationService authService;
	
	public AuthenticationController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserQuery user) {
		return ResponseEntity.ok("df");
	}

	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody NewUser newUser) {
		System.out.println("INSIDE THE SIGNUP endpoint....");
		return ResponseEntity.ok(authService.signup(newUser));
	}
	
	
}
