package com.lina.airline.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImp {

    private final JavaMailSender javaMailSender;


    public String sendMail(String email, String subject, String body) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("stackflowover3@gmail.com");
            simpleMailMessage.setTo(email);
            simpleMailMessage.setText(body);
            simpleMailMessage.setSubject(subject);
            javaMailSender.send(simpleMailMessage);
            return "Mail Sent Successfully...";


        } catch (Exception e) {
            return "error";
        }

    }
}
