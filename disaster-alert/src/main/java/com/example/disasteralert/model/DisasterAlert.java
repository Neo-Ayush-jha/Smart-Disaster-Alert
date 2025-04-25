package com.example.disasteralert.model; // ✅ Yahi hona chahiye

import jakarta.persistence.*;

@Entity
@Table(name = "disaster_alert")
public class DisasterAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alertMessage;
    private String description;
    private String disasterType;
    private String location;

    // Constructors
    public DisasterAlert() {}

    public DisasterAlert(String alertMessage, String description, String disasterType, String location) {
        this.alertMessage = alertMessage;
        this.description = description;
        this.disasterType = disasterType;
        this.location = location;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAlertMessage() { return alertMessage; }
    public void setAlertMessage(String alertMessage) { this.alertMessage = alertMessage; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDisasterType() { return disasterType; }
    public void setDisasterType(String disasterType) { this.disasterType = disasterType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
