package com.gabriel.celebration.domain.services;

import com.gabriel.celebration.domain.ports.IMessageRepository;

public class DeleteAllMessages {

    private IMessageRepository messageRepository;

    public DeleteAllMessages(IMessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public boolean execute(){
        boolean wasDeleted = messageRepository.deleteAll();
        return wasDeleted;
    }
}
