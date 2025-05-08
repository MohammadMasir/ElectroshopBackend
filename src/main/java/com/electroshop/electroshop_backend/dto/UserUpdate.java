package com.electroshop.electroshop_backend.dto;

import java.util.Optional;

public record UserUpdate(
		Long id, 
		Optional<String> firstName, 
		Optional<String> lastName, 
		Optional<String> email, 
		Optional<String> address
		) {}
