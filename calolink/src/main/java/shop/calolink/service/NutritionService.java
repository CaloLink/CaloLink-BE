package shop.calolink.service;

import shop.calolink.domain.dto.NutritionResponse;

public interface NutritionService {
    NutritionResponse getByFood(Long foodId);
}
