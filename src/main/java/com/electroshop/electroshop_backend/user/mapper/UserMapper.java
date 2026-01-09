package com.electroshop.electroshop_backend.user.mapper;

import com.electroshop.electroshop_backend.user.domain.User;
import com.electroshop.electroshop_backend.user.dto.user.NewUser;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
//	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "password", qualifiedByName = "encodePassword")
	User toUser(NewUser newUser, @Context PasswordEncoder passwordEncoder);
	
	NewUser toDto(User user);
	
	@Named("encodePassword")
	default String encodePassword(String password, @Context PasswordEncoder passwordEncoder) {
		return passwordEncoder.encode(password);
	}
	
}
