package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.ports.UserRepository;

public class CreateUsers {

    private UserRepository userRepository;

    public CreateUsers(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User execute(User user){
        User newUser = userRepository.create(user);
        return newUser;
    }
}
