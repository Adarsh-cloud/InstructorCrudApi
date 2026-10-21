package com.onetoone.controller;

import com.onetoone.service.notification.NotificationService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class NotificationController {

    private NotificationService notificationService;

    @Autowired
    public NotificationController(@Qualifier("notification-prod") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notification")
    public String getNotification() {
        System.out.println("NotificationController.getNotification()");
        return notificationService.sendNotification("Hello");
    }
}
