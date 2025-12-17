package shop.calolink.domain.dto.res;

import lombok.Builder;
import shop.calolink.domain.enums.Category;

import java.util.List;

public class FoodResDto {

    @Builder
    public record FoodMarketInfoDto(
            String link,
            Integer price
    ){}

    @Builder
    public record FoodDetailDto(
            Long foodId,
            String name,
//            String manufacturer
            Category category,
            String imageUrl,
            NutritionResDto.NutritionDetailDto nutrition,
            List<FoodMarketInfoDto> marketInfos
    ){}

    @Builder
    public record FoodSummaryDto(
        String foodName,
        String imageUrl,
        Double carb,
        Double protein,
        Double fat
    ){}

    @Builder
    public record FoodSummaryListDto (
            List<FoodSummaryDto> foodList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}
}
