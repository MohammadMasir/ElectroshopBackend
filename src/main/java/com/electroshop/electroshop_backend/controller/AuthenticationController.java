package com.electroshop.electroshop_backend.controller;

import com.electroshop.electroshop_backend.dto.user.UserLogin;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.electroshop.electroshop_backend.dto.user.NewUser;
import com.electroshop.electroshop_backend.service.AuthenticationService;

@RestController
@RequestMapping("/electroshop")
public class AuthenticationController {
	
	private AuthenticationService authService;
	
	public AuthenticationController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLogin user) {
		try{
			String token = authService.login(user);
			return new ResponseEntity<>(token,HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody NewUser newUser) {
			if (authService.signup(newUser)){
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
	
	
}
