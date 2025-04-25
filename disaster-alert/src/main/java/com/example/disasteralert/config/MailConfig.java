package com.example.disasteralert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        // MailTrap SMTP Configuration
        mailSender.setHost("sandbox.smtp.mailtrap.io");
        mailSender.setPort(2525);
        mailSender.setUsername("2d0aa77ce11375");  // Replace with your MailTrap username
        mailSender.setPassword("1818080de4ea56");  // Replace with your MailTrap password

        // Set mail properties (optional but useful for fine-tuning)
        mailSender.getJavaMailProperties().put("mail.smtp.connectiontimeout", "10000"); // 10 seconds
        mailSender.getJavaMailProperties().put("mail.smtp.timeout", "10000"); // 10 seconds
        mailSender.getJavaMailProperties().put("mail.smtp.writetimeout", "10000"); // 10 seconds
        mailSender.setProtocol("smtp");

        return mailSender;
    }
}
