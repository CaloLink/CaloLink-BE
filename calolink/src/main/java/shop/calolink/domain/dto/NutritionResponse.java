package shop.calolink.domain.dto;

public record NutritionResponse(
        Double kcal,
        Double protein,
        Double fat,
        Double carb,
        Double sugar,
        Double cholesterol,
        Double saturatedFat,
        Double transFat,
        Double sodium
) {}
