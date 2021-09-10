package com.neki.api.mapper;

import org.springframework.stereotype.Component;

import com.neki.api.dto.SkillDto;
import com.neki.api.entity.SkillEntity;

@Component
public class SkillMapper {

	public SkillDto toDto(SkillEntity entity) {
		var dto = new SkillDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setVersion(entity.getVersion());
		dto.setDescription(entity.getDescription());
		dto.setImageUrl(entity.getImageUrl());
		return dto;
		
	}
	public SkillEntity toEntity(SkillDto dto) {
		var entity = new SkillEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setVersion(dto.getVersion());
		entity.setDescription(dto.getDescription());
		entity.setImageUrl(dto.getImageUrl());
		return entity;
		
	}
}
