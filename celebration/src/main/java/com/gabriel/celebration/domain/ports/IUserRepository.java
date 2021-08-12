package com.gabriel.celebration.domain.ports;

import com.gabriel.celebration.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> fetchAll();
    User create(User user);
    boolean deleteAll();
    Optional<User> findById(int id);
}
