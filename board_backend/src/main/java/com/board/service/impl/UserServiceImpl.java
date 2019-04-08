package com.board.service.impl;

import com.board.dto.UserWithPasswordDTO;
import com.board.model.User;
import com.board.repository.UserRepository;
import com.board.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public void createNewUser(UserWithPasswordDTO user) {
        userRepository.save(modelMapper.map(user, User.class));
    }
}
