package com.board.controller;

import com.board.dto.UserWithPasswordDTO;
import com.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public void createNewUser(@RequestBody UserWithPasswordDTO userDTO) {
        userService.createNewUser(userDTO);
    }
}
