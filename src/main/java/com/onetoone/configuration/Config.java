package com.onetoone.configuration;

import com.onetoone.service.notification.NotificationService;
import com.onetoone.service.notification.NotificationServiceDevImpl;
import com.onetoone.service.notification.NotificationServiceProdImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

    @Profile("dev")
    @Bean("devProfile")
    public String devProfile(){
        System.out.println("dev profile is active");
        return "devProfile";
    }
    @Profile("prod")
    @Bean("prodProfile")
    public String prodProfile(){
        System.out.println("prod profile is active");
        return  "prodProfile";
    }

    @Bean("notification-prod")
    @Profile("prod")
    public NotificationService prodNotificationService(){
        return new NotificationServiceProdImpl();
    }
    @Bean("notification-dev")
    @Profile("dev")
    public NotificationService devNotificationService(){
        return  new NotificationServiceDevImpl();
    }
}
