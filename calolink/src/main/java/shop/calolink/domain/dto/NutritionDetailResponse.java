package shop.calolink.domain.dto;

import shop.calolink.domain.entity.Nutrition;

public record NutritionDetailResponse(
        Integer kcal,
        Integer protein,
        Integer fat,
        Integer carb,
        Integer sugar,
        Integer cholesterol,
        Integer saturatedFat,
        Integer transFat,
        Integer sodium
) {
    public static NutritionDetailResponse from(Nutrition nutrition) {
        if (nutrition == null)
            return null;

        return new NutritionDetailResponse(
                nutrition.getKcal(),
                // Double -> Integer
                (int) Math.round(nutrition.getProtein()),
                (int) Math.round(nutrition.getFat()),
                (int) Math.round(nutrition.getCarb()),
                (int) Math.round(nutrition.getSugar()),
                (int) Math.round(nutrition.getCholesterol()),
                (int) Math.round(nutrition.getSaturatedFat()),
                (int) Math.round(nutrition.getTransFat()),
                nutrition.getSodium()
        );
    }
}
