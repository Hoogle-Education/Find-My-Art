package com.lucas.findmyart.repository;

import com.lucas.findmyart.model.entities.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRepository extends JpaRepository<Pub, Long> {

}
