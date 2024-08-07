package com.stupnikov.notification_bot;

import com.stupnikov.notification_bot.configuration.TelegramProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TelegramProperties.class)
public class NotificationBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationBotApplication.class, args);
	}

}
