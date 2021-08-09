package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.ports.MessageRepository;

public class CreateMessages {
    private MessageRepository messageRepository;

    public CreateMessages(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message execute(Message message){
        Message newMessage = messageRepository.create(message);
        return newMessage;
    }

}
