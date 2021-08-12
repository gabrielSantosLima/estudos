package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.ports.IMessageRepository;
import com.gabriel.celebration.domain.ports.IUserRepository;

import java.util.Optional;

public class CreateMessages {

    private IMessageRepository messageRepository;
    private IUserRepository userRepository;

    public CreateMessages(IMessageRepository messageRepository, IUserRepository userRepository){
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public Message execute(Message message) throws Exception {
        Optional<User> user = userRepository.findById(message.getUserId());

        if(user.isEmpty()){
            throw new Exception("Usuário não existe.");
        }

        Message newMessage = messageRepository.create(message);
        return newMessage;
    }

}
