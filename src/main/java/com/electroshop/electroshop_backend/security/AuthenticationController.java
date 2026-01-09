package com.electroshop.electroshop_backend.security;

import com.electroshop.electroshop_backend.user.dto.user.NewUser;
import com.electroshop.electroshop_backend.user.dto.user.UserLogin;
import com.electroshop.electroshop_backend.user.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/electroshop")
public class AuthenticationController {
	
	private final AuthenticationService authService;
	private final AdminService adminService;
	
	public AuthenticationController(AuthenticationService authService, AdminService adminService) {
		this.authService = authService;
		this.adminService = adminService;
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

	@Transactional
	@PutMapping("/admin/register")
	public ResponseEntity<String> adminRegister(@Valid @RequestParam Long employeeId) {
			if (authService.employeeExist(employeeId)){
				return new ResponseEntity<>(adminService.makeEmployeeAdmin(employeeId),HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
	/*
	@PostMapping("/admin/register")
	public ResponseEntity<?> adminSetPassword(@Valid @RequestBody SetAdminPassword password) {
			if (authService.employeeExist(employeeId)){
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }*/

	/*
	@PostMapping("/admin/login")
	public ResponseEntity<?> adminLogin(@Valid @RequestBody AdminLogin adminLogin) {
			if (authService.login(newUser)){
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }*/

	/*
	@PostMapping("/seller/register")
	public ResponseEntity<?> sellerSignup(@Valid @RequestBody NewUser newUser) {
			if (authService.signup(newUser)){
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
*/
	
	
}
