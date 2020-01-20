package fr.ynov.paullereverend.b3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.ynov.paullereverend.b3.services.TimelineService;

@Configuration
public class AppConfig {

	@Bean
    public TimelineService transferService() {
        return new TimelineService();
    }
}
