package com.example.aitest.service;

import com.example.aitest.model.MealCategoryResponse;
import com.example.aitest.model.MealResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MealService {
    private final WebClient webClient;

    @Autowired
    public MealService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.themealdb.com/api/json/v1/1").build();
    }

    public Mono<MealCategoryResponse> fetchMealCategories() {
        return webClient
                .get()
                .uri("/list.php?c=list")
                .retrieve()
                .bodyToMono(MealCategoryResponse.class);
    }
    public Mono<MealResponse> fetchMealsByCategory(String category) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/filter.php").queryParam("i", category).build())
                .retrieve()
                .bodyToMono(MealResponse.class);
    }
}
