package com.lucas.findmyart.repository;

import com.lucas.findmyart.model.entities.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

    Optional<Band> findByUsername(String username);

}
