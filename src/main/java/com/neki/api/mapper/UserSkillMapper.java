package com.neki.api.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neki.api.dto.UserDto;
import com.neki.api.dto.UserSkillDto;
import com.neki.api.entity.SkillEntity;
import com.neki.api.entity.UserEntity;
import com.neki.api.entity.UserSkillEntity;
import com.neki.api.repository.SkillRepository;
import com.neki.api.repository.UserRepository;

@Component
public class UserSkillMapper {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SkillRepository skillRepository;

	public UserSkillDto toDto(UserSkillEntity entity) {
		var dto = new UserSkillDto();
		dto.setId(entity.getId());
		dto.setUser(entity.getUser());
		dto.setSkill(entity.getSkill());
		dto.setKnowledgeLevel(entity.getKnowledgeLevel());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setUpdatedAt(entity.getUpdatedAt());
		return dto;
		
	}
	
	public UserSkillEntity toEntity(UserSkillDto dto) {
		var entity = new UserSkillEntity();
		entity.setId(dto.getId());	
		Optional<UserEntity> user = userRepository.findById(dto.getUserId());
		if(user.isPresent()) {
		entity.setUser(user.get());
		}
		Optional<SkillEntity> skill = skillRepository.findById(dto.getSkillId());
		if(skill.isPresent()) {
			entity.setSkill(skill.get());
		}
		entity.setKnowledgeLevel(dto.getKnowledgeLevel());
		if(dto.getCreatedAt() == null) {
			entity.setCreatedAt(LocalDate.now());
		}
		if(dto.getCreatedAt() != null) {
			entity.setUpdatedAt(LocalDateTime.now());
		}		
		return entity;
		
	}
}
