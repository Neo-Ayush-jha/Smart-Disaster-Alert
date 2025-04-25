package com.example.disasteralert.controller;

import com.example.disasteralert.model.User;
import com.example.disasteralert.service.UserService;
import com.example.disasteralert.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        try {
            // Generate token if not already set inside registerUser
            String token = savedUser.getVerificationToken();
            if (token == null || token.isEmpty()) {
                token = userService.generateAndSaveVerificationToken(savedUser);
            }
            emailService.sendVerificationEmail(savedUser.getEmail(), token);
        } catch (MessagingException e) {
            return ResponseEntity.internalServerError().body("Error sending verification email.");
        }
        return ResponseEntity.ok("Registration successful! Please check your email to verify.");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam String token) {
        Optional<User> user = userService.verifyUser(token);
        if (user.isPresent()) {
            return ResponseEntity.ok("Email verified successfully! You can now login.");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired verification token.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> loginUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (loginUser.isPresent()) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials or email not verified.");
        }
    }
}
