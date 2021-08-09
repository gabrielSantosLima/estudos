package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.ports.MessageRepository;

import java.util.List;

public class FindMessageByUserId {
    private MessageRepository messageRepository;

    public FindMessageByUserId(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public List<Message> execute(int id) throws Exception {
        List<Message> messages = messageRepository.findByUserId(id);
        return messages;
    }
}
