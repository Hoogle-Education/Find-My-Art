package com.lucas.findmyart.controller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterForm {

	private String name;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private String role;
	
}
