package com.electroshop.electroshop_backend.security;

import com.electroshop.electroshop_backend.user.dto.NewUser;
import com.electroshop.electroshop_backend.user.dto.UserLogin;
import com.electroshop.electroshop_backend.user.mapper.UserMapper;
import com.electroshop.electroshop_backend.user.domain.User;
import com.electroshop.electroshop_backend.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;
	
	public AuthenticationService(
			UserRepository userRepository, 
			JwtService jwtService,
			AuthenticationManager authenticationManager, 
			PasswordEncoder passwordEncoder,
			UserMapper userMapper
			) {
		this.userRepository = userRepository;
		this.jwtService = jwtService;
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
	
	public String login(UserLogin user) {
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.phoneNumber(), user.password())
				);
		return jwtService.generateToken(userRepository.findByPhoneNumber(user.phoneNumber()).orElseThrow());
	} catch (AuthenticationException e) {
		throw new RuntimeException(e);
		}
	}
	
	
}

