package com.electroshop.electroshop_backend.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record NewUser(
		@Pattern(regexp = "^[7896][0-9]{9}$", message = "Enter valid phone number.")
		@NotBlank(message = "Please provide phone number.")
		@Size(min = 10, max = 10)
		String phoneNumber,

		@Pattern(regexp = "^[a-zA-Z]+$", message = "Digits and special characters are not allowed.")
		@NotBlank
		String firstName,

		@Pattern(regexp = "^[a-zA-Z]+$", message = "Digits and special characters are not allowed.")
		@NotBlank
		String lastName,

		@NotBlank
		String countryCode,

		@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^+-=&*])[a-zA-Z0-9!@#$%+-=^&*]{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
		@NotBlank
		String password
		) {}
