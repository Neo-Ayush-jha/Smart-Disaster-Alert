package com.example.disasteralert.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String to, String token) throws MessagingException {
        String subject = "Email Verification";
        String verificationUrl = "http://localhost:8080/api/users/verify?token=" + token;
        String content = "<p>Thank you for registering.</p>"
                + "<p>Please click the link below to verify your email:</p>"
                + "<a href=\"" + verificationUrl + "\">VERIFY</a>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }
}
