package com.neki.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.api.dto.LoginRequest;
import com.neki.api.dto.LoginResponse;
import com.neki.api.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin("http://localhost:3000/")
    @PostMapping
    public LoginResponse login (@RequestBody LoginRequest request) {
        return userService.login(request.getLogin(), request.getPassword());
    }

}
