package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.ports.IUserRepository;

import java.util.List;

public class FetchAllUsers {

    private IUserRepository userRepository;

    public FetchAllUsers(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> execute(){
        List<User> users = userRepository.fetchAll();
        return users;
    }
}
