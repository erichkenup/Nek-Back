package com.neki.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.neki.api.entity.SkillEntity;
import com.neki.api.entity.UserEntity;

public class UserSkillDto {

	private Integer id;
	private UserEntity user;	
	private SkillEntity skill;
	private Integer userId;
	private Integer skillId;
	private Integer knowledgeLevel;
	private LocalDate createdAt;
	private LocalDateTime updatedAt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public SkillEntity getSkill() {
		return skill;
	}
	public void setSkill(SkillEntity skill) {
		this.skill = skill;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	public Integer getKnowledgeLevel() {
		return knowledgeLevel;
	}
	public void setKnowledgeLevel(Integer knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
