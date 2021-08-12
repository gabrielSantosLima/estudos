package com.gabriel.celebration.domain.entities;

public class Message {
    private int id;
    private String content;
    private String emailReceiver;
    private int userId;

    public Message(int id, String content, String emailReceiver, int userId){
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

    public String getEmailReceiver() {
        return emailReceiver;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return getContent();
    }
}
