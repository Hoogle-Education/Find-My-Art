package com.lucas.findmyart.model.user.api;

import com.lucas.findmyart.config.exception.APIException;
import com.lucas.findmyart.model.user.User;
import com.lucas.findmyart.model.user.api.dto.UserDto;
import com.lucas.findmyart.model.user.api.form.UserForm;
import com.lucas.findmyart.service.UserService;
import com.lucas.findmyart.service.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/0.0.1/users")
@AllArgsConstructor
public class UserResource {
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> users = userService
                .getAll()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/search", params = "id")
    public ResponseEntity<UserDto> getUser(@RequestParam Long id) {
        User user = userService.getById(id);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(new UserDto(user));
    }

    @GetMapping(value = "/search", params = "username")
    public ResponseEntity<UserDto> getUser(@RequestParam String username) {
        User user = userService.getByUsername(username);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(new UserDto(user));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserForm userForm)
            throws APIException {

        User registeredUser;

        try {
            registeredUser = userService.register(userForm);
        } catch (UserNotFoundException notFoundException) {
            throw new APIException(notFoundException.getMessage(),
                    "",
                    notFoundException.getHttpStatus());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new UserDto(registeredUser));
    }


}
