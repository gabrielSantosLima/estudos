package com.gabriel.celebration.domain.ports;

import com.gabriel.celebration.domain.entities.Message;

public interface IEmailSender {
    boolean sendEmail(Message message);
}
