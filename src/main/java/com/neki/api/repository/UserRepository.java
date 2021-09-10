package com.neki.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neki.api.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> { 
	
	Optional<UserEntity> findByLogin(String login);
}
