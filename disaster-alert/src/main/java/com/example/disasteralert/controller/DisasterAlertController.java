package com.example.disasteralert.controller;

import com.example.disasteralert.model.DisasterAlert;
import com.example.disasteralert.service.DisasterAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class DisasterAlertController {

    @Autowired
    private DisasterAlertService service;

    @GetMapping
    public List<DisasterAlert> getAllAlerts() {
        return service.getAllAlerts();
    }

    @PostMapping
    public DisasterAlert createAlert(@RequestBody DisasterAlert alert) {
        return service.saveAlert(alert);
    }
}
