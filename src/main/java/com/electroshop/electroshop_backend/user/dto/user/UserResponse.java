package com.electroshop.electroshop_backend.user.dto.user;

public record UserResponse(
		String firstName,
		String lastName,
		String email,
		String address
		) {}
