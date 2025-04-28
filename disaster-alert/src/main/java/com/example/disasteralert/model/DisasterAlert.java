package com.example.disasteralert.model; // ✅ Correct

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

    private Double latitude;   // ✅ New
    private Double longitude;  // ✅ New
    private Double radius;     // ✅ New (in kilometers)

    // Constructors
    public DisasterAlert() {}

    public DisasterAlert(String alertMessage, String description, String disasterType, Double latitude, Double longitude, Double radius) {
        this.alertMessage = alertMessage;
        this.description = description;
        this.disasterType = disasterType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
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

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Double getRadius() { return radius; }
    public void setRadius(Double radius) { this.radius = radius; }
}
