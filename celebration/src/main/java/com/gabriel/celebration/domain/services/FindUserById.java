package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.ports.UserRepository;

import java.util.Optional;

public class FindUserById {

    private UserRepository userRepository;

    public FindUserById(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User execute(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new Exception("Usuário não existe.");
        }
        return user.get();
    }
}
