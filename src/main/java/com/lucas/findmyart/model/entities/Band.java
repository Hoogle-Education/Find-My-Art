package com.lucas.findmyart.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.lucas.findmyart.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Band")
@Getter @Setter
public class Band extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "band_genres",
        joinColumns = { @JoinColumn(name = "band_id") },
        inverseJoinColumns = { @JoinColumn(name = "genre_id") } )
    private Set<Genre> genres = new HashSet<>(); // lista de entidades únicas

}
