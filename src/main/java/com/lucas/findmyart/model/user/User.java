package com.lucas.findmyart.model.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter @NoArgsConstructor
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String profilePhotoToken;

  private String username;
  private String email;
  private String password;
  private Boolean enabled;

  @OneToOne
  @JoinColumn(name = "authority_id")
  private Authority authority;


}
