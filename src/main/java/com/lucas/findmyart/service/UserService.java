package com.lucas.findmyart.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.lucas.findmyart.controller.dto.LoginForm;
import com.lucas.findmyart.controller.dto.RegisterForm;
import com.lucas.findmyart.model.enums.Role;
import com.lucas.findmyart.model.user.Authority;
import com.lucas.findmyart.repository.AuthorityRepository;
import com.lucas.findmyart.service.exceptions.RegisterException;
import com.lucas.findmyart.service.exceptions.RoleMissmatchException;
import com.lucas.findmyart.service.exceptions.UserAlreadyRegisteredException;
import com.lucas.findmyart.service.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import com.lucas.findmyart.model.user.User;
import com.lucas.findmyart.repository.UserRepository;
import com.lucas.findmyart.resource.form.UserForm;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	private UserRepository userRepository;
	private AuthorityRepository authorityRepository;

	private User toUser(UserForm userForm) {
		User user = new User();
		Role role = null;

		user.setUsername(userForm.getUsername());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setEnabled(true);

		switch (userForm.getRole().toUpperCase()) {
		case "MUSICIAN" -> role = Role.MUSICIAN;
		case "PUB" -> role = Role.PUB;
		default -> throw new RoleMissmatchException(userForm.getRole());
		}

		Optional<Authority> authority = authorityRepository.findByRole(role);
		Authority newAuthorityRegistered = null;

		if (authority.isEmpty())
			newAuthorityRegistered = registerAuthority(role);

		user.setAuthority(authority.orElse(newAuthorityRegistered));
		return user;
	}

	private User toUser(RegisterForm registerDTO) {
		User user = new User();
		Role role = null;

		user.setUsername(registerDTO.getUsername());
		user.setEmail(registerDTO.getEmail());
		user.setPassword(registerDTO.getPassword());
		user.setEnabled(true);

		switch (registerDTO.getRole().toUpperCase()) {
		case "BAND" -> role = Role.MUSICIAN;
		case "PUB" -> role = Role.PUB;
		default -> throw new RoleMissmatchException(registerDTO.getRole());
		}

		Optional<Authority> authority = authorityRepository.findByRole(role);
		Authority newAuthorityRegistered = null;

		if (authority.isEmpty())
			newAuthorityRegistered = registerAuthority(role);

		user.setAuthority(authority.orElse(newAuthorityRegistered));
		return user;
	}

	private boolean isUserAlreadyRegistered(String username) {
		return userRepository.findByUsername(username).isPresent();
	}

	// pegar todos os usuários da base de dados
	public List<User> getAll() {
		return userRepository.findAll();
	}

	public List<User> getUsersByAuthority(String role) {
		return userRepository.findAll().stream()
				.filter(user -> user.getAuthority().getRole().toString().equalsIgnoreCase(role))
				.collect(Collectors.toList());
	}

	public User getById(Long id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found by this id!"));
	}

	public User getByUsername(String username) throws UserNotFoundException {

		return userRepository.findAll().stream().filter(user -> user.getUsername().equalsIgnoreCase(username))
				.findFirst().orElseThrow(() -> new UserNotFoundException("user not found by this username!"));

//    return userRepository.findByUsername(username)
//            .orElseThrow(() -> new UserNotFoundException("user not found by this username!"));
	}

	public User register(UserForm userForm) throws UserAlreadyRegisteredException {
		if (isUserAlreadyRegistered(userForm.getUsername())) {
			String errorMessage = "Username \"" + userForm.getUsername() + "\" already registered!";
			throw new UserAlreadyRegisteredException(errorMessage);
		}

		User user = toUser(userForm);
		return register(user);
	}

	public User register(RegisterForm registerForm) throws UserAlreadyRegisteredException {
		if (isUserAlreadyRegistered(registerForm.getUsername())) {
			String errorMessage = "Username \"" + registerForm.getUsername() + "\" already registered!";
			throw new UserAlreadyRegisteredException(errorMessage);
		}

		User user = toUser(registerForm);
		return register(user);
	}

	private User register(User user) {
		return userRepository.save(user);
	}

	private Authority registerAuthority(Role role) throws RegisterException {
		Authority aux = new Authority();
		aux.setRole(role);
		authorityRepository.save(aux);

		return authorityRepository.findByRole(role)
				.orElseThrow(() -> new RegisterException("Authority register error"));
	}

	public void login(LoginForm loginForm) {

	}

}
