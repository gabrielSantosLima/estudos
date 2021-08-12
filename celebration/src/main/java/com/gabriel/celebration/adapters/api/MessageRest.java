package com.gabriel.celebration.adapters.api;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.ports.IMessageRepository;
import com.gabriel.celebration.domain.ports.IUserRepository;
import com.gabriel.celebration.domain.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageRest {

    @Autowired
    private IMessageRepository messageRepository;

    @Autowired
    private IUserRepository userRepository;

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message message) throws Exception {
        CreateMessages createMessages = new CreateMessages(messageRepository, userRepository);
        createMessages.execute(message);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping
    public ResponseEntity<Message> deleteAll(){
        DeleteAllMessages deleteAllMessages = new DeleteAllMessages(messageRepository);
        deleteAllMessages.execute();
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") int id) throws Exception {
        FindMessageById findMessageById = new FindMessageById(messageRepository);
        Message message = findMessageById.execute(id);
        return message;
    }

    @GetMapping("/user/{userId}")
    public List<Message> findByUserId(@PathVariable("userId") int userId) throws Exception {
        FindMessageByUserId findMessageByUserId = new FindMessageByUserId(messageRepository);
        List<Message> messages = findMessageByUserId.execute(userId);
        return messages;
    }

}
