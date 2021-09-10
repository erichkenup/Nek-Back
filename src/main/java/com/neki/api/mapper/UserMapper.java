package com.neki.api.mapper;

import org.springframework.stereotype.Component;

import com.neki.api.dto.UserDto;
import com.neki.api.entity.UserEntity;

@Component
public class UserMapper {

	public UserDto toDto(UserEntity entity) {
		var dto = new UserDto();
		dto.setId(entity.getId());
		dto.setLogin(entity.getLogin());
		dto.setPassword(entity.getPassword());
		dto.setLastLoginDate(entity.getLastLoginDate());
		return dto;
		
	}
	public UserEntity toEntity(UserDto dto) {
		var entity = new UserEntity();
		entity.setId(dto.getId());
		entity.setLogin(dto.getLogin());
		entity.setPassword(dto.getPassword());
		entity.setLastLoginDate(dto.getLastLoginDate());
		return entity;
		
	}
}
