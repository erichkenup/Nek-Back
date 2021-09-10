package com.neki.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.neki.api.dto.UserDto;
import com.neki.api.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserDto> findAll() {
		return userService.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto user) {
		return new ResponseEntity<UserDto>(userService.create(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<UserDto > update(@PathVariable(value = "id") Integer id,
                                             @RequestBody UserDto user) throws Exception {
        return new ResponseEntity<>(userService.update(user, id), HttpStatus.OK);
    } 
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> delete (@PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
	}
}
