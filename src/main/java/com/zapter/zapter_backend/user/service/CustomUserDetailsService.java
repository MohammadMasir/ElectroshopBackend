package com.zapter.zapter_backend.user.service;

import com.zapter.zapter_backend.user.repository.AdminRepository;
import com.zapter.zapter_backend.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	final private UserRepository userRepository;
	final private AdminRepository adminRepository;

	public CustomUserDetailsService(
			UserRepository userRepository,
			AdminRepository adminRepository
	) {
		this.userRepository = userRepository;
		this.adminRepository = adminRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
		if (identifier.length()==10){
			return userRepository.findByPhoneNumber(identifier).orElseThrow();
		} else {
			return adminRepository.findByAdminId(identifier).orElseThrow();
		}
	}
}
