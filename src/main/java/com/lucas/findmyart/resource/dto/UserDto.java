package com.lucas.findmyart.resource.dto;

import com.lucas.findmyart.model.user.User;
import com.lucas.findmyart.util.GravatarTokenFactory;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class UserDto {

    private String profileImageToken;
    private String username;
    private String email;
    private Boolean enabled;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.enabled = user.getEnabled();
        this.profileImageToken = GravatarTokenFactory.gravatarHex(email);
    }

}
