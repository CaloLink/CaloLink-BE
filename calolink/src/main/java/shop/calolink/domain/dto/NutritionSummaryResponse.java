package shop.calolink.domain.dto;

import shop.calolink.domain.entity.Nutrition;

public record NutritionSummaryResponse(
        Integer carbs,
        Integer protein,
        Integer fat
) {
    public static NutritionSummaryResponse from(Nutrition nutrition) {
        return new NutritionSummaryResponse(
                // Double -> Integer
                (int) Math.round(nutrition.getCarb()),
                (int) Math.round(nutrition.getProtein()),
                (int) Math.round(nutrition.getFat())
        );
    }
}
