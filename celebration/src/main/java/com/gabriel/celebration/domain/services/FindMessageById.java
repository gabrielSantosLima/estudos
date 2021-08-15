package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.exceptions.MessageNotFoundException;
import com.gabriel.celebration.domain.ports.IMessageRepository;

import java.util.Optional;

public class FindMessageById {
    private IMessageRepository messageRepository;

    public FindMessageById(IMessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message execute(int id) throws Exception {
        Optional<Message> message = messageRepository.findById(id);
        if(message.isEmpty()){
            throw new MessageNotFoundException();
        }
        return message.get();
    }
}
