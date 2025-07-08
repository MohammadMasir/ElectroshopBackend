package com.electroshop.electroshop_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electroshop.electroshop_backend.dto.user.NewUser;
import com.electroshop.electroshop_backend.dto.user.UserQuery;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/electroshop/auth")
public class AuthenticationController {
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserQuery user) {
		return ResponseEntity.ok("df");
	}

	@PostMapping("/signup")
	public String signup(@RequestBody NewUser newUser) {
		return "";
	}
	
	
}
