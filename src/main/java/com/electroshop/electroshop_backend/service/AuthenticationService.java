package com.electroshop.electroshop_backend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.electroshop.electroshop_backend.domain.User;
import com.electroshop.electroshop_backend.dto.user.NewUser;
import com.electroshop.electroshop_backend.dto.user.UserQuery;
import com.electroshop.electroshop_backend.mapper.UserMapper;
import com.electroshop.electroshop_backend.repository.UserRepository;
import com.electroshop.electroshop_backend.security.JwtUtil;

@Service
public class AuthenticationService {

	private final UserRepository userRepository;
//	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;
	
	public AuthenticationService(
			UserRepository userRepository, 
			JwtUtil jwtUtil, 
			AuthenticationManager authenticationManager, 
			PasswordEncoder passwordEncoder,
			UserMapper userMapper
			) {
		this.userRepository = userRepository;
//		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
	}

	public boolean signup(NewUser newUserDto) {
        try {
            if (newUserDto != null){
                User newUser = userMapper.toUser(newUserDto, passwordEncoder);
                userRepository.save(newUser);
                return true;
            }
			return false;
        } catch (Exception e) {
            return false;
        }
	}
	
//	public String login(UserQuery user) {
//		try {
//			authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(user.phoneNumber(), user.password())
//				);
//
//		return jwtUtil.generateToken();
//
//	} catch (AuthenticationException e) {
//		// TODO Auto-generated catch block
////		e.printStackTrace();
//		return "";
//		}
//	}
	
	
}

