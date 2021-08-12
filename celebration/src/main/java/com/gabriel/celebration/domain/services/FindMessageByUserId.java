package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.ports.IMessageRepository;

import java.util.List;

public class FindMessageByUserId {
    private IMessageRepository messageRepository;

    public FindMessageByUserId(IMessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public List<Message> execute(int userId) throws Exception {
        List<Message> messages = messageRepository.findByUserId(userId);
        return messages;
    }
}
