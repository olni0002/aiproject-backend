package com.example.aitest.controller;

import com.example.aitest.model.MealCategoryResponse;
import com.example.aitest.model.MealResponse;
import com.example.aitest.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping("/meal-categories")
    public Mono<MealCategoryResponse> getMealCategories() {
        return mealService.fetchMealCategories();
    }
    @GetMapping("/meals/{category}")
    public Mono<MealResponse> getMealsByCategory(@PathVariable String category) {
        return mealService.fetchMealsByCategory(category);
    }
}
