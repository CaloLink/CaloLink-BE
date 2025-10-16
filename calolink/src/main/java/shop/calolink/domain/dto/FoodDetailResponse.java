package shop.calolink.domain.dto;

import shop.calolink.Category;
import shop.calolink.domain.entity.Food;

public record FoodDetailResponse(
        Long id,
        String name,
        Category category,
        String manufacturer,
        String imageUrl,
        NutritionDetailResponse nutritionResponse
) {
    public static FoodDetailResponse from(Food food) {
        return new FoodDetailResponse(
                food.getId(),
                food.getName(),
                food.getCategory(),
                food.getManufacturer(),
                food.getImageUrl(),
                NutritionDetailResponse.from(food.getNutrition())
        );
    }
}

