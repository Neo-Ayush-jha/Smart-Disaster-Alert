package com.example.disasteralert.service;

import com.example.disasteralert.model.User;
import com.example.disasteralert.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Generate a token during registration
        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);
        user.setEnabled(false); // user not enabled until verified
        return userRepository.save(user);
    }

    public String generateAndSaveVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);
        userRepository.save(user);
        return token;
    }

    public Optional<User> verifyUser(String token) {
        Optional<User> userOptional = userRepository.findByVerificationToken(token);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEnabled(true); // set user as verified
            user.setVerificationToken(null); // Clear the token after verification
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public Optional<User> loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);
        return userOptional.filter(User::isEnabled); // only allow login if verified
    }
}
