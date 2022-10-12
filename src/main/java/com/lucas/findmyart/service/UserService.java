package com.lucas.findmyart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucas.findmyart.model.User;
import com.lucas.findmyart.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

}
