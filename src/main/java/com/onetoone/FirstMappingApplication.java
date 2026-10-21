package com.onetoone;


import com.onetoone.service.notification.NotificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMappingApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext){

        return runner->{
			System.out.println("Inside the runner");
			String message =null;
			NotificationService notificationService=null;
			if (applicationContext.containsBean("devProfile")){
                 message = applicationContext.getBean("devProfile", String.class);
				System.out.println("message is :: "+message);
			}
			if(applicationContext.containsBean("prodProfile")){
				message = applicationContext.getBean("prodProfile", String.class);
				System.out.println("message is :: "+message);
			}

			if(applicationContext.containsBean("notification-dev")){
				notificationService = applicationContext.getBean("notification-dev", NotificationService.class);
				System.out.println(notificationService.sendNotification("dev - notifications"));
			}
			if(applicationContext.containsBean("notification-prod")){
				notificationService= applicationContext.getBean("notification-prod",NotificationService.class);
				System.out.println(notificationService.sendNotification("prod- notifications"));
			}

		};
    }

}
