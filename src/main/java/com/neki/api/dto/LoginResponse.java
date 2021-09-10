package com.neki.api.dto;

import com.neki.api.entity.UserEntity;

public class LoginResponse {
	
	private String token;
	
	private UserEntity userEntity;
		
	public LoginResponse(String token, UserEntity UserEntity) {
		this.token = token;
		this.userEntity = UserEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
		
}
