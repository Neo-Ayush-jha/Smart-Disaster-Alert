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
@CrossOrigin(origins = "http://localhost:5173") // Important to fix your CORS error with React
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);

            String token = savedUser.getVerificationToken();
            if (token == null || token.isEmpty()) {
                token = userService.generateAndSaveVerificationToken(savedUser);
            }

            emailService.sendVerificationEmail(savedUser.getEmail(), token);

            return ResponseEntity.ok("✅ Registration successful! Please check your email to verify.");
        } catch (MessagingException e) {
            return ResponseEntity.internalServerError().body("❌ Error sending verification email.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ Registration failed: " + e.getMessage());
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam String token) {
        Optional<User> user = userService.verifyUser(token);
        if (user.isPresent()) {
            return ResponseEntity.ok("✅ Email verified successfully! You can now login.");
        } else {
            return ResponseEntity.badRequest().body("❌ Invalid or expired verification token.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> loginUser = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (loginUser.isPresent()) {
            return ResponseEntity.ok("✅ Login successful!");
        } else {
            return ResponseEntity.badRequest().body("❌ Invalid credentials or email not verified.");
        }
    }

    // Inner static class for clean login input
    public static class LoginRequest {
        private String email;
        private String password;

        // Getters and Setters
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
}
