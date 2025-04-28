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

    // ✅ Registration ke time verification email
    public void sendVerificationEmail(String to, String token) throws MessagingException {
        String subject = "Email Verification";
        String verificationUrl = "http://localhost:8080/api/users/verify?token=" + token;
        String content = "<p>Thank you for registering.</p>"
                + "<p>Please click the link below to verify your email:</p>"
                + "<a href=\"" + verificationUrl + "\">VERIFY</a>";

        sendHtmlEmail(to, subject, content);
    }

    // ✅ New: Disaster Alert email
    public void sendAlertEmail(String to, String disasterType, String alertMessage) throws MessagingException {
        String subject = "🚨 Disaster Alert: " + disasterType;
        String content = "<p>Dear User,</p>"
                + "<p><strong>Disaster Type:</strong> " + disasterType + "</p>"
                + "<p><strong>Alert:</strong> " + alertMessage + "</p>"
                + "<br><p>Stay safe!</p>";

        sendHtmlEmail(to, subject, content);
    }

    // ✅ Common private method to send HTML emails
    private void sendHtmlEmail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }
}
