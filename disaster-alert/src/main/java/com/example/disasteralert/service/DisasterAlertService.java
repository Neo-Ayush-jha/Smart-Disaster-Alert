package com.example.disasteralert.service;

import com.example.disasteralert.model.DisasterAlert;
import com.example.disasteralert.model.User;
import com.example.disasteralert.repository.DisasterAlertRepository;
import com.example.disasteralert.repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisasterAlertService {

    @Autowired
    private DisasterAlertRepository disasterAlertRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public List<DisasterAlert> getAllAlerts() {
        return disasterAlertRepository.findAll();
    }

    public DisasterAlert saveAlert(DisasterAlert alert) {
        DisasterAlert savedAlert = disasterAlertRepository.save(alert);

        // Notify nearby users
        notifyNearbyUsers(savedAlert);

        return savedAlert;
    }

    private void notifyNearbyUsers(DisasterAlert alert) {
        List<User> users = userRepository.findAll();  // Fetch all users
        for (User user : users) {
            if (user.getLatitude() != null && user.getLongitude() != null) {
                double distance = calculateDistance(
                        alert.getLatitude(), alert.getLongitude(),
                        user.getLatitude(), user.getLongitude()
                );
                if (distance <= alert.getRadius()) {  // User within radius
                    try {
                        emailService.sendAlertEmail(
                                user.getEmail(),
                                alert.getDisasterType(),
                                alert.getAlertMessage()
                        );
                        System.out.println("✅ Email sent to: " + user.getEmail());
                    } catch (MessagingException e) {
                        System.out.println("❌ Failed to send email to: " + user.getEmail());
                    }
                }
            }
        }
    }

    // Haversine formula to calculate distance between two lat/lng points in KM
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in KM
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance;
    }
}
