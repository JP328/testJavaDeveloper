package com.testJavaDeveloper.services;

import com.testJavaDeveloper.dtos.NotificationDTO;
import com.testJavaDeveloper.model.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(Client client, String message) throws Exception {
        String email = client.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        System.out.print("Notificação enviada com sucesso!");
    }
}
