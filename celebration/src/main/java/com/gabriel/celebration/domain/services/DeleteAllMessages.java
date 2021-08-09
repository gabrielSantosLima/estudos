package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.ports.MessageRepository;

public class DeleteAllMessages {

    private MessageRepository messageRepository;

    public DeleteAllMessages(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public boolean execute(){
        boolean wasDeleted = messageRepository.deleteAll();
        return wasDeleted;
    }
}
