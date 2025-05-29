package com.electroshop.electroshop_backend.mapper;

import org.mapstruct.Mapper;

import com.electroshop.electroshop_backend.domain.User;
import com.electroshop.electroshop_backend.dto.user.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponse toDto(User user);
	User toEntity(UserResponse response);
	
}
