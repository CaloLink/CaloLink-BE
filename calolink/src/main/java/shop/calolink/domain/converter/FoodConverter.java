package shop.calolink.domain.converter;

import org.springframework.data.domain.Page;
import shop.calolink.domain.dto.res.FoodResDto;
import shop.calolink.domain.dto.res.NutritionResDto;
import shop.calolink.domain.entity.Food;

import java.util.List;

public class FoodConverter {

//    public static FoodResDto.FoodDetailDto toFoodDetailDto(Food food) {
//        return FoodResDto.FoodDetailDto.builder()
//                .foodId(food.getId())
//                .name(food.getName())
//                .category(food.getCategory())
//                .imageUrl(food.getImageUrl())
//                .nutrition(food.getNutrition())
//    }

    public static FoodResDto.FoodSummaryDto toFoodSummaryDto(Food food) {
        return FoodResDto.FoodSummaryDto.builder()
                .foodName(food.getName())
                .imageUrl(food.getImageUrl())
                .carb(food.getNutrition().getCarb())
                .protein(food.getNutrition().getProtein())
                .fat(food.getNutrition().getFat())
                .build();
    }

    public static FoodResDto.FoodSummaryListDto toFoodSummaryListDto(Page<Food> result) {
        return FoodResDto.FoodSummaryListDto.builder()
                .foodList(result.getContent().stream()
                        .map(FoodConverter::toFoodSummaryDto)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static NutritionResDto.NutritionDetailDto toDetailDto(Food food) {
        return NutritionResDto.NutritionDetailDto.builder()
                .kcal(food.getNutrition().getKcal())
                .protein(food.getNutrition().getProtein())
                .fat(food.getNutrition().getFat())
                .carb(food.getNutrition().getCarb())
                .sugar(food.getNutrition().getSugar())
                .cholesterol(food.getNutrition().getCholesterol())
                .saturatedFat(food.getNutrition().getSaturatedFat())
                .transFat(food.getNutrition().getTransFat())
                .sodium(food.getNutrition().getSodium())
                .build();

    }

    public static FoodResDto.FoodDetailDto toFoodDetailDto(Food food) {

        NutritionResDto.NutritionDetailDto nutritionDto = FoodConverter.toDetailDto(food);

        List<FoodResDto.FoodMarketInfoDto> marketInfoDto = food.getMarketInfos().stream()
                .map(market -> FoodResDto.FoodMarketInfoDto.builder()
                        .link(market.getLink())
                        .price(market.getPrice())
                        .build())
                .toList();


        return FoodResDto.FoodDetailDto.builder()
                .foodId(food.getId())
                .name(food.getName())
                .category(food.getCategory())
                .imageUrl(food.getImageUrl())
                .nutrition(nutritionDto)
                .marketInfos(marketInfoDto)
                .build();
    }
}
