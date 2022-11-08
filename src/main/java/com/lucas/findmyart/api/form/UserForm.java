package com.lucas.findmyart.api.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@AllArgsConstructor
public class UserForm {

    @NotEmpty
    private String username;

    @NotEmpty @Email
    private String email;

    @NotEmpty
    private String password;

    private String role;

}
