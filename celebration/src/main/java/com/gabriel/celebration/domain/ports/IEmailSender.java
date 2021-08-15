package com.gabriel.celebration.domain.ports;

import com.gabriel.celebration.domain.entities.Message;

public interface IEmailSender {
    void sendEmail(Message message) throws Exception;
}
