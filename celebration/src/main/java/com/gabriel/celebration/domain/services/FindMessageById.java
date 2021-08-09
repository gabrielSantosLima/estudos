package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.ports.MessageRepository;

import java.util.Optional;

public class FindMessageById {
    private MessageRepository messageRepository;

    public FindMessageById(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message execute(int id) throws Exception {
        Optional<Message> message = messageRepository.findById(id);
        if(message.isEmpty()){
            throw new Exception("Messagem não existe.");
        }
        return message.get();
    }
}
