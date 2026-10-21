package com.onetoone.service.notification;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class NotificationServiceDevImpl implements NotificationService{
    @Override
    public String sendNotification(String message) {
        return message+" this is a notification of dev";
    }
}
