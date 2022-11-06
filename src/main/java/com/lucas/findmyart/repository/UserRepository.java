package com.lucas.findmyart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.findmyart.model.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);

}
