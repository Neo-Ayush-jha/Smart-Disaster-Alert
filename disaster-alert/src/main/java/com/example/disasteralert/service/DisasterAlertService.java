package com.example.disasteralert.service;

import com.example.disasteralert.model.DisasterAlert;
import com.example.disasteralert.repository.DisasterAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DisasterAlertService {

    @Autowired
    private DisasterAlertRepository repository;

    public List<DisasterAlert> getAllAlerts() {
        return repository.findAll();
    }

    public DisasterAlert saveAlert(DisasterAlert alert) {
        return repository.save(alert);
    }
}
