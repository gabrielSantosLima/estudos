package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.exceptions.UserNotFoundException;
import com.gabriel.celebration.domain.ports.IEmailSender;
import com.gabriel.celebration.domain.ports.IMessageRepository;
import com.gabriel.celebration.domain.ports.IUserRepository;

import java.util.Optional;

public class CreateMessages {

    private IMessageRepository messageRepository;
    private IUserRepository userRepository;
    private IEmailSender emailSender;

    public CreateMessages(
            IMessageRepository messageRepository,
            IUserRepository userRepository,
            IEmailSender emailSender
    ){
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public Message execute(Message message) throws Exception {
        Optional<User> user = userRepository.findById(message.getUserId());

        if(user.isEmpty()){
            throw new UserNotFoundException();
        }

        emailSender.sendEmail(message);

        Message newMessage = messageRepository.create(message);
        return newMessage;
    }

}
