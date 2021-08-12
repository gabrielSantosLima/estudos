package com.gabriel.celebration;

import com.gabriel.celebration.adapters.db.MessageRepository;
import com.gabriel.celebration.domain.entities.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MessageRepositoryTests {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    void messageShouldBeCreated(){
        Message message = new Message(0,
                "Isso é uma exemplo de mensagem",
                "teste@gmail.com",
                1);
        Assertions.assertDoesNotThrow(() -> {
            messageRepository.create(message);
        });
    }

    @Test
    void messageShouldntBeCreatedBecauseUserIdIsInvalid(){
        Message message = new Message(0,
                "Isso é uma exemplo de mensagem",
                "teste@gmail.com",
                999);
        Assertions.assertThrows(Exception.class, () -> {
            messageRepository.create(message);
        });
    }

    @Test
    void messagesShoudBeFoundById(){
        int id = 1;
        String expectedContent = "Isso é uma exemplo de mensagem";
        Assertions.assertEquals(expectedContent, messageRepository.findById(id).get().getContent());
    }

    @Test
    void messagesShoudBeFoundByUserId(){
        int userId = 1;
        Assertions.assertEquals(ArrayList.class, messageRepository.findByUserId(userId).getClass());
    }
}
