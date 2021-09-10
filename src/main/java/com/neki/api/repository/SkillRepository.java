package com.neki.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neki.api.entity.SkillEntity;
import com.neki.api.entity.UserEntity;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Integer>{

	Optional<SkillEntity> findByName(String name);
}
