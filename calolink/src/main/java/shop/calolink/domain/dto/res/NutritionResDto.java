package shop.calolink.domain.dto.res;

import lombok.Builder;

import java.util.List;

public class NutritionResDto {

    @Builder
    public record NutritionSummaryDto(
            Double carbs,
            Double protein,
            Double fat
    ){}

    @Builder
    public record NutritionSummaryListDto(
            List<NutritionSummaryDto> nutritionList,
            Integer listSize,
            Integer totalPage,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record NutritionDetailDto(
            Integer kcal,
            Double protein,
            Double fat,
            Double carb,
            Double sugar,
            Double cholesterol,
            Double saturatedFat,
            Double transFat,
            Integer sodium
    ){}
}
