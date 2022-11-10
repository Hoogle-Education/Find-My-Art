package com.lucas.findmyart.model.entities;

import com.lucas.findmyart.model.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bands")
@DiscriminatorValue("Band")
public class Band extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "band_genres",
        joinColumns = { @JoinColumn(name = "band_id") },
        inverseJoinColumns = { @JoinColumn(name = "genre_id") } )
    private Set<Genre> genres = new HashSet<>();

}
