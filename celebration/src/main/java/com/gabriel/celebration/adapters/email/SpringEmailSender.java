package com.gabriel.celebration.adapters.email;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.exceptions.EmailNotSendException;
import com.gabriel.celebration.domain.ports.IEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

@Service
public class SpringEmailSender implements IEmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    private final String SUBJECT = "Celebration - Mensagem Personalizada";
    private final String EMAIL_FILE_NAME = "email.html";
    private final String HTML_VALUE = "text/html";

    @Override
    public void sendEmail(Message message) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject(SUBJECT);
        mimeMessageHelper.setTo(message.getEmailReceiver());

        String content = processTemplate(message);

        mimeMessage.setContent(content, HTML_VALUE);

        try{
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            throw new EmailNotSendException();
        }
    }

    private String processTemplate(Message message){
        Context context = new Context();
        context.setVariable("content", message.getContent());
        String html = springTemplateEngine.process(EMAIL_FILE_NAME, context);
        return html;
    }
}
