package com.gabriel.celebration.domain.ports;

import com.gabriel.celebration.domain.entities.User;

import java.util.Optional;

public interface UserRepository {
    User create(User user);
    boolean deleteAll();
    Optional<User> findById(int id);
}
