package com.example.disasteralert.repository;

import com.example.disasteralert.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByVerificationToken(String verificationToken);

    Optional<User> findByEmailAndPassword(String email, String password);
}
