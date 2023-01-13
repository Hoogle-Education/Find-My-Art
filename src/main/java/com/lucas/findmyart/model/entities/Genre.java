package com.lucas.findmyart.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genres")
@Getter @Setter
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
