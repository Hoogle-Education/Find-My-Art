package com.lucas.findmyart.model.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // torna uma entidade mapeada para o banco de dados
@Table(name = "users") // crio tabela com este nome
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // jogo pra uma tabela
// a classificação é feita por uma coluna chamada user_type
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter @NoArgsConstructor // get, set e construtor sem argumentos
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String profilePhotoToken;
  
  private String name;
  private String username;
  private String about;
  private String email;
  private String password;
  private Boolean enabled;
  @OneToOne
  @JoinColumn(name = "authority")
  private Authority authority;

}
