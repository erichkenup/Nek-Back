package com.neki.api.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.neki.api.dto.LoginResponse;
import com.neki.api.dto.UserDto;
import com.neki.api.entity.UserEntity;
import com.neki.api.mapper.UserMapper;
import com.neki.api.repository.UserRepository;
import com.neki.api.security.JWTService;

@Service
public class UserService {
	
	private static final String headerPrefix = "Bearer ";
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEnconder;
		
	public List<UserDto> findAll() {
		List<UserEntity> UserList = userRepository.findAll();
		return UserList.stream()
				.map(user -> userMapper.toDto(user))
				.collect(Collectors.toList());
	}
	
	public UserDto create (UserDto user)  {
		String senha = passwordEnconder.encode(user.getPassword());
        user.setPassword(senha);
		userRepository.save(userMapper.toEntity(user));
		return user;
		
	}
	
	public UserDto update (UserDto user, Integer id) throws Exception {
		UserEntity userEntity = userMapper.toEntity(user);
		try {
			userEntity.setId(id);
			return userMapper.toDto(userRepository.save(userEntity));
		} catch (Exception e) {
			throw new Exception("id not found");
		}
	}
	
	public String delete (Integer id) throws Exception {
		try {
			UserEntity user = userRepository.findById(id).get();
			userRepository.delete(user);
			return "Successfully deleted";
		} catch (Exception e) {
			throw new Exception("Id not found");
		}
	}
	
	public LoginResponse login(String username, String password) {

        Authentication autenticacao = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList()));

        SecurityContextHolder.getContext().setAuthentication(autenticacao);

        String token = headerPrefix + jwtService.gerarToken(autenticacao);

        var usuario = userRepository.findByLogin(username);
        usuario.get().setLastLoginDate(LocalDate.now());
        
        return new LoginResponse(token, usuario.get());
    }
	
}
	

