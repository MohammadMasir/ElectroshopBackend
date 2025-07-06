package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.electroshop.electroshop_backend.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	UserDetails findByPhoneNumber(String phoneNumber);
	
}
