package com.gabriel.celebration.domain.entities;

import com.gabriel.celebration.domain.valueobjects.Email;

public class Message {
    private int id;
    private String content;
    private Email emailReceiver;
    private int userId;

    public Message(int id, String content, Email emailReceiver, int userId){
        this.id = id;
        this.content = content;
        this.emailReceiver = emailReceiver;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Email getEmailReceiver() {
        return emailReceiver;
    }

    public String getContent() {
        return content;
    }
}
