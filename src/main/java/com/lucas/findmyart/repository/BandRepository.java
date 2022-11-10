package com.lucas.findmyart.repository;

import com.lucas.findmyart.model.entities.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

}
