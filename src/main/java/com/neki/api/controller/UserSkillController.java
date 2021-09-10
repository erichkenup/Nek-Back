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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neki.api.dto.UserSkillDto;
import com.neki.api.service.UserSkillService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/userSkill")
public class UserSkillController {

	@Autowired
    UserSkillService userSkillService;
	
	@GetMapping
	private ResponseEntity<List<UserSkillDto>> findAll (@RequestParam String login){
		return new ResponseEntity<>(userSkillService.findAll(login), HttpStatus.OK);
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<UserSkillDto> findById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(this.userSkillService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserSkillDto> create(@RequestBody UserSkillDto userSkill) throws Exception {
        return new ResponseEntity<>(this.userSkillService.create(userSkill), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserSkillDto> atualizar(@PathVariable(value = "id") Integer id, @RequestBody UserSkillDto userSkill) throws Exception {
        return new ResponseEntity<>(this.userSkillService.update(id, userSkill), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
	private ResponseEntity<String> delete (@PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(userSkillService.delete(id), HttpStatus.OK);
	}

    
}
