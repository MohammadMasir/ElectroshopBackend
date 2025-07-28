package com.electroshop.electroshop_backend.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserLogin(
		@Pattern(regexp = "^[7896][0-9]{9}$", message = "Enter valid phone number.")
		@NotBlank(message = "Please provide phone number.")
		@Size(min = 10, max = 10)
		String phoneNumber,

		@NotBlank(message = "Please enter the password.")
		String password
		) 
	{}
