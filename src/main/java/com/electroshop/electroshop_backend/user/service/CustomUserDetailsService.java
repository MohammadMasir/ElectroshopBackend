package com.electroshop.electroshop_backend.user.service;

import com.electroshop.electroshop_backend.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
		return userRepository.findByPhoneNumber(phoneNumber).orElseThrow();
	}

	
	
}
