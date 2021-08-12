package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.ports.IUserRepository;

public class DeleteAllUsers {
    private IUserRepository userRepository;

    public DeleteAllUsers(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean execute(){
        boolean wasDeleted = userRepository.deleteAll();
        return wasDeleted;
    }
}
