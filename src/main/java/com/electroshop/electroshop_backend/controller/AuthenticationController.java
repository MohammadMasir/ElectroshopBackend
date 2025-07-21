package com.electroshop.electroshop_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.electroshop.electroshop_backend.domain.User;
import com.electroshop.electroshop_backend.dto.user.NewUser;
import com.electroshop.electroshop_backend.dto.user.UserQuery;
import com.electroshop.electroshop_backend.service.AuthenticationService;

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
	@ResponseBody
	public User signup(@RequestBody NewUser newUser) {
		System.out.println("INSIDE THE SIGNUP endpoint....");
		return authService.signup(newUser);
	}
	
	
}
