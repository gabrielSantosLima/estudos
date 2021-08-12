package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.ports.IUserRepository;

public class CreateUsers {

    private IUserRepository userRepository;

    public CreateUsers(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User execute(User user){
        User newUser = userRepository.create(user);
        return newUser;
    }
}
