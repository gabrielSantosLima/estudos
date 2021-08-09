package com.gabriel.celebration.domain.entities;

import com.gabriel.celebration.domain.valueobjects.Email;

public class User {
    private int id;
    private String name;
    private Email email;

    public User(int id, String name, Email email){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
