package shop.calolink.domain.dto;

import shop.calolink.domain.entity.Food;

public record FoodSummaryResponse(
        Long id,
        String name,
        String imageUrl,
        NutritionSummaryResponse nutritionResponse
) {
    public static FoodSummaryResponse from(Food food) {
        return new FoodSummaryResponse(
                food.getId(),
                food.getName(),
                food.getImageUrl(),
                NutritionSummaryResponse.from(food.getNutrition())
        );
    }
}
