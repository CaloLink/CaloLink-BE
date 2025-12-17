package shop.calolink.service;

import org.springframework.data.domain.Pageable;
import shop.calolink.domain.enums.Category;
import shop.calolink.domain.dto.res.FoodResDto;

public interface FoodQueryService {

    FoodResDto.FoodSummaryListDto searchFoods(String name, Category category, Pageable pageable);

    FoodResDto.FoodDetailDto getFoodDetailById(Long id);
}
