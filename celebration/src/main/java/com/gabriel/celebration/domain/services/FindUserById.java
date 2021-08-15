package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.exceptions.UserNotFoundException;
import com.gabriel.celebration.domain.ports.IUserRepository;

import java.util.Optional;

public class FindUserById {

    private IUserRepository userRepository;

    public FindUserById(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User execute(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user.get();
    }
}
