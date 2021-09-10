package com.neki.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.api.dto.SkillDto;
import com.neki.api.entity.SkillEntity;
import com.neki.api.mapper.SkillMapper;
import com.neki.api.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	private SkillMapper skillMapper;
		
	public List<SkillDto> findAll() {
		List<SkillEntity> skillList = skillRepository.findAll();
		return skillList.stream()
				.map(skill -> skillMapper.toDto(skill))
				.collect(Collectors.toList());
	}
	
	public SkillDto findByName(String name) {
		SkillEntity skill = skillRepository.findByName(name).get();
		return skillMapper.toDto(skill);
	}
	
	public SkillDto create (SkillDto skill)  {
		skillRepository.save(skillMapper.toEntity(skill));
		return skill;
	}
	
	public SkillDto update (SkillDto skill, Integer id) throws Exception {
		SkillEntity skillEntity = skillMapper.toEntity(skill);
		try {
			skillEntity.setId(id);
			return skillMapper.toDto(skillRepository.save(skillEntity));
		} catch (Exception e) {
			throw new Exception("id not found");
		}
	}
	
	public String delete (Integer id) throws Exception {
		try {
			SkillEntity skill = skillRepository.findById(id).get();
			skillRepository.delete(skill);
			return "Successfully deleted";
		} catch (Exception e) {
			throw new Exception("Id not found");
		}
	}
}
