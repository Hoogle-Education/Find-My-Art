package com.lucas.findmyart.model.entities;

import com.lucas.findmyart.model.user.User;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Pub")
public class Pub extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
