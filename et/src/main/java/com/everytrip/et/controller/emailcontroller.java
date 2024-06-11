package com.everytrip.et.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everytrip.et.dto.emaildto;

@CrossOrigin("*")
@RestController
public class emailcontroller {
    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody emaildto emailRequest) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailRequest.getEmail());
            message.setSubject("New Contact Form Submission");
            message.setText("Name: " + emailRequest.getName() + "\nEmail: " + emailRequest.getEmail() + "\nMessage: "
            + emailRequest.getMessage() + "\nYour verification code is: " + emailRequest.getVerificationCode() + "\nPlease type this code to continue.");
            emailSender.send(message); 
            return "Email sent successfully!";
        } catch (MailException exception) {
            return "Error sending email: " + exception.getMessage();
        }
    }
}
