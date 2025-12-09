package shop.calolink.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shop.calolink.Category;
import shop.calolink.domain.converter.FoodConverter;
import shop.calolink.domain.dto.res.FoodResDto;
import shop.calolink.domain.entity.Food;
import shop.calolink.domain.exception.FoodException;
import shop.calolink.domain.exception.code.FoodErrorCode;
import shop.calolink.repository.food.FoodRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class FoodQueryServiceImpl implements FoodQueryService{

    private final FoodRepository foodRepository;

    @Override
    public FoodResDto.FoodSummaryListDto searchFoods(String name, Category category, Pageable pageable) {

        Page<Food> foods = foodRepository.searchFoods(name, category, pageable);

        if (foods.isEmpty())
            throw new FoodException(FoodErrorCode.FOOD_NOT_FOUND);

        return FoodConverter.toFoodSummaryListDto(foods);
    }

    @Override
    public FoodResDto.FoodDetailDto getFoodDetailById(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new FoodException(FoodErrorCode.FOOD_NOT_FOUND));

        return FoodConverter.toFoodDetailDto(food);
    }

}
