package com.board.controller;

import com.board.dto.UserWithPasswordDTO;
import com.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/create")
    public String createNewUser() {
        UserWithPasswordDTO userDTO = new UserWithPasswordDTO();
        userDTO.setLogin("login");
        userDTO.setEmail("email@gmail.com");
        userDTO.setFirstName("name");
        userDTO.setLastName("surname");
        userDTO.setPassword("password");
        userService.createNewUser(userDTO);
        return "";
    }
}
