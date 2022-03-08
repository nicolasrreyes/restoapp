package com.resto.restoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.resto.restoapp.dto.UserRegisterDTO;
import com.resto.restoapp.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

	private UserService userService;

	public RegisterUserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegisterDTO returnNewUserRgisterDTO() {
		return new UserRegisterDTO();
	}
	
	@GetMapping
	public String showRegisterForm() {
		return "register";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisterDTO registerDTO) {
		userService.save(registerDTO);
		return "redirect:/register?success";
	}
	
}

