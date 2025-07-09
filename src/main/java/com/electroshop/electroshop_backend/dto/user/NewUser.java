package com.electroshop.electroshop_backend.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NewUser(
		@NotBlank(message = "Please provide phone number.")
		@Size(min = 10, max = 10)
		String phoneNumber,
		@NotBlank
		String firstName,
		@NotBlank
		String lastName,
		@NotBlank
		String countryCode,
		@NotBlank
		@Size(min = 6, message = "Password must be at least 6 characters.")
		String password
		) {}
