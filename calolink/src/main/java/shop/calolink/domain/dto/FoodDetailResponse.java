package shop.calolink.domain.dto;

import shop.calolink.Category;

import java.util.List;

public record FoodDetailResponse(
        Long id,
        String name,
        String manufacturer,
        Category category,
        NutritionResponse nutritionResponse
) {}

