package com.neki.api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.api.dto.UserSkillDto;
import com.neki.api.entity.UserSkillEntity;
import com.neki.api.mapper.UserSkillMapper;
import com.neki.api.repository.UserRepository;
import com.neki.api.repository.UserSkillRepository;

@Service
public class UserSkillService {

	@Autowired
	private UserSkillMapper userSkillMapper;
	
	@Autowired
	UserSkillRepository userSkillRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public List<UserSkillDto> findAll(String login){
		List<UserSkillEntity> userSkillEntity = userSkillRepository.
				findAllByUser(userRepository.findByLogin(login).get());
		
		
		return userSkillEntity.stream()
				.map(userSkill -> userSkillMapper.toDto(userSkill))
				.collect(Collectors.toList());
	}
	
	
    public UserSkillDto create(UserSkillDto userSkillDto) throws Exception {
        UserSkillEntity userSkill = new UserSkillEntity();
        userSkill = userSkillMapper.toEntity(userSkillDto);
        try {
        	userSkill.setCreatedAt(LocalDate.now());
        	userSkillRepository.save(userSkill);
        } catch (Exception e) {
            throw new Exception("Create user skill erro");
        }
        return userSkillMapper.toDto(userSkill);

    }


    public UserSkillDto update(Integer id, UserSkillDto userSkillDto) throws Exception {
    	UserSkillEntity userSkill = userSkillMapper.toEntity(userSkillDto);
        try {
        	userSkill.setId(id);
        	userSkill.setUpdatedAt(LocalDateTime.now());
            return userSkillMapper.toDto(userSkillRepository.save(userSkill));
        } catch (Exception e) {
            throw new Exception("Id not found");
        }
    }


    public UserSkillDto findById(Integer id) throws Exception {
        try {
            return userSkillMapper.toDto(userSkillRepository.findById(id).get());
        } catch (Exception e) {
            throw new Exception("Id not found");
        }
    }
    
    public String delete (Integer id) throws Exception {
		try {
			UserSkillEntity userSkill = userSkillRepository.findById(id).get();
			userSkillRepository.delete(userSkill);
			return "Successfully deleted";
		} catch (Exception e) {
			throw new Exception("Id not found");
		}
	}
}
