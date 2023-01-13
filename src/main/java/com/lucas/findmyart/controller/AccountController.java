package com.lucas.findmyart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucas.findmyart.controller.dto.LoginForm;
import com.lucas.findmyart.controller.dto.RegisterForm;
import com.lucas.findmyart.service.UserService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccountController {
	
	@NonNull private UserService userService;
	private String lastOriginRole;
	
	@GetMapping("login")
	public String login() {
		return "forms/login";
	}
	
	@GetMapping("logout")
	public String logout() {
		return "redirect:home";
	}
	
	@PostMapping("login/join")
	public String login(LoginForm loginForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(System.out::println);			
			return "redirect:forms/register";
		}
		
		userService.login(loginForm);
		return "redirect:home";
	}
	
	@GetMapping("register")
	public String register() {
		return "forms/register";
	}
	
	@GetMapping("register/band")
	public String bandRegister(RegisterForm registerForm) {
		this.lastOriginRole = "band";
		return "forms/band_register";
	}
	
	@GetMapping("register/pub")
	public String pubRegister(RegisterForm registerForm) {
		this.lastOriginRole = "pub";
		return "forms/pub_register";
	}
	
	@PostMapping("register/new")
	public String register(RegisterForm registerForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(System.out::println);			
			return "redirect:forms/register";
		}
		
		registerForm.setRole(lastOriginRole);
		userService.register(registerForm);
		return "redirect:home";
	}
	
}
