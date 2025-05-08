package com.electroshop.electroshop_backend.dto;

public record UserResponse(
		String firstName,
		String lastName,
		String email,
		String address
		) {}
