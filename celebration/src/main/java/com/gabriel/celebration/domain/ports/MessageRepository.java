package com.gabriel.celebration.domain.ports;

import com.gabriel.celebration.domain.entities.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    Message create(Message message);
    boolean deleteAll();
    Optional<Message> findById(int id);
    List<Message> findByUserId(int userId);
}
