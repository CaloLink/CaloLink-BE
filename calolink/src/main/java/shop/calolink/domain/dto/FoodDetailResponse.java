package shop.calolink.domain.dto;

import shop.calolink.Category;

public record FoodDetailResponse(
        Long id,
        String name,
        String manufacturer,
        Category category,
        Integer kcal,
        Integer carbs,
        Integer protein,
        Integer fat,
        String imageUrl
) {
}
