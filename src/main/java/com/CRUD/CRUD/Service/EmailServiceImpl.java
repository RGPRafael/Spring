/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CRUD.CRUD.Service;

import com.CRUD.CRUD.models.EmailDetails;
import com.CRUD.CRUD.models.SenhaTemporaria;
import org.oxerr.commons.user.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael
 */
@Service
public class EmailServiceImpl{
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.username}") private String sender;
    
    @Autowired
    private SenhaTemporariaService senhaTemporariaService;
    
    
    public Boolean sendSimpleMail(String recipient)
    {
 
        // Try block to check for exceptions
        try {
 
            SenhaTemporaria temporaryPassword = senhaTemporariaService.returnOneTimePassword(recipient);
            
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(recipient);
            mailMessage.setText(temporaryPassword.getSenhatemporaria());
            mailMessage.setSubject("New Password");
 
            // Sending the mail
            mailSender.send(mailMessage);
            return true;
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
    
}


/********************************************************************************************
https://stackoverflow.com/questions/13112811/how-to-insert-current-date-into-mysql-database-use-java

************************************************************************************************/

