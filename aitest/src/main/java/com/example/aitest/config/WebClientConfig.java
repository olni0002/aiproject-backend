package com.example.aitest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.aitest.model.Body;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

	@Bean
	public Body.BodyBuilder bodyBuilder() {
		return Body.builder();
	}

}