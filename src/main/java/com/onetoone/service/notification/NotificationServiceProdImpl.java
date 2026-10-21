package com.onetoone.service.notification;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class NotificationServiceProdImpl implements NotificationService{
    @Override
    public String sendNotification(String message) {
        return message+" Send the prod Notification";
    }
}
