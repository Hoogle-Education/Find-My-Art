package com.lucas.findmyart.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String profilePhoto;

  private String username;
  private String email;
  private String password;
  private Boolean enabled;

  @OneToOne
  @JoinColumn(name = "authority_id")
  private Authority authority;

}
