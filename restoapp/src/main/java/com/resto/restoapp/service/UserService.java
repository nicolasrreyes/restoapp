package com.resto.restoapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.resto.restoapp.dto.UserRegisterDTO;
import com.resto.restoapp.entity.User;

public interface UserService extends UserDetailsService{
	
	public User save(UserRegisterDTO registerDTO);

}
