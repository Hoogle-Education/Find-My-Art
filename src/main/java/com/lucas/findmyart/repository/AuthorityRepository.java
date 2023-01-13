package com.lucas.findmyart.repository;

import com.lucas.findmyart.model.enums.Role;
import com.lucas.findmyart.model.user.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // ponte para a base de dados e dá recursos java para manipularmos a base
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByRole(Role role);

}
