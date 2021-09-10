package com.neki.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neki.api.entity.UserEntity;
import com.neki.api.entity.UserSkillEntity;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkillEntity,Integer>{
	
	List<UserSkillEntity> findAllByUser (UserEntity user);
}
