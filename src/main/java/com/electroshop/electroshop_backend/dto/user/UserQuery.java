package com.electroshop.electroshop_backend.dto.user;

public record UserQuery(
		String phoneNumber,
		String password
		) 
	{
	
	public String getUsername() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}
	
	}
