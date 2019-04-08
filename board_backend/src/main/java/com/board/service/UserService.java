package com.board.service;

import com.board.dto.UserDTO;
import com.board.dto.UserWithPasswordDTO;

public interface UserService {

    void createNewUser(UserWithPasswordDTO user);
}
