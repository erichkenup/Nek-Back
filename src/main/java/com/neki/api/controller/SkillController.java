package com.neki.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.api.dto.SkillDto;
import com.neki.api.service.SkillService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/skill")
public class SkillController {
	@Autowired
	private SkillService skillService;
	
	@GetMapping
	public List<SkillDto> findAll() {
		return skillService.findAll();
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<SkillDto> findByName(@PathVariable(value = "name") String name) {
		return new ResponseEntity<SkillDto>(skillService.findByName(name), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<SkillDto> create(@RequestBody SkillDto skill) {
		return new ResponseEntity<SkillDto>(skillService.create(skill), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<SkillDto > update (@PathVariable(value = "id") Integer id,
                                             @RequestBody SkillDto skill) throws Exception {
        return new ResponseEntity<>(skillService.update(skill, id), HttpStatus.OK);
    } 
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> delete (@PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(skillService.delete(id), HttpStatus.OK);
	}
}
