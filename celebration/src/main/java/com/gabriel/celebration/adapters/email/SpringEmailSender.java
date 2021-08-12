package com.gabriel.celebration.adapters.email;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.ports.IEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SpringEmailSender implements IEmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    private final String SUBJECT = "Celebration - Mensagem Personalizada";

    @Override
    public boolean sendEmail(Message message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(SUBJECT);
        simpleMailMessage.setTo(message.getEmailReceiver());
        simpleMailMessage.setText(message.getContent());

        try{
            javaMailSender.send(simpleMailMessage);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
