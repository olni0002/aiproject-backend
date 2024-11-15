package com.example.aitest.model;
import java.util.List;

public class MealCategoryResponse {
    private List<Category> meals;

    public List<Category> getMeals() {
        return meals;
    }

    public void setMeals(List<Category> meals) {
        this.meals = meals;
    }

    public static class Category {
        private String strCategory;

        public String getStrCategory() {
            return strCategory;
        }

        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }
    }
}
