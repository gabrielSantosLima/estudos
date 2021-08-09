package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.ports.UserRepository;

public class DeleteAllUsers {
    private UserRepository userRepository;

    public DeleteAllUsers(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean execute(){
        boolean wasDeleted = userRepository.deleteAll();
        return wasDeleted;
    }
}
