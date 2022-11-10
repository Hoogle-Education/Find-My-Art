package com.lucas.findmyart.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String genre;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Band> bands = new HashSet<>();

}
