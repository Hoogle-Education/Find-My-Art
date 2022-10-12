package com.lucas.findmyart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.findmyart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
}
