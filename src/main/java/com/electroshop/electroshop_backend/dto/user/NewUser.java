package com.electroshop.electroshop_backend.dto.user;

public record NewUser(
		String phoneNumber,
		String firstName,
		String lastName,
		String countryCode,
		String password
		) {}
