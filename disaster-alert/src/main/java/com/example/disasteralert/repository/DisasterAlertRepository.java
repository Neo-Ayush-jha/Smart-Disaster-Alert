package com.example.disasteralert.repository;

import com.example.disasteralert.model.DisasterAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisasterAlertRepository extends JpaRepository<DisasterAlert, Long> {
}
