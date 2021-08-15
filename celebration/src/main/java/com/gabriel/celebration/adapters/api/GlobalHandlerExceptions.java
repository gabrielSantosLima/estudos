package com.gabriel.celebration.adapters.api;

import com.gabriel.celebration.domain.exceptions.EmailNotSendException;
import com.gabriel.celebration.domain.exceptions.MessageNotFoundException;
import com.gabriel.celebration.domain.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler(EmailNotSendException.class)
    public ResponseEntity<String> emailNotSend(){
        return ResponseEntity.status(400).body("Erro no envio de email.");
    }

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<String> messageNotFound(){
        return ResponseEntity.status(400).body("Messagem não encontrada ou não existe.");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFound(){
        return ResponseEntity.status(400).body("Usuário não encontrado ou não existe.");
    }

}
