package shop.calolink.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shop.calolink.Category;
import shop.calolink.domain.dto.FoodDetailResponse;
import shop.calolink.domain.dto.FoodSummaryResponse;
import shop.calolink.domain.entity.Food;
import shop.calolink.repository.FoodRepository;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public Page<FoodSummaryResponse> searchFoods(String name, Category category, Pageable pageable) {
        Page<Food> foodPage;
        // ❗️ 빈 문자열도 체크하도록 수정
        boolean hasName = (name != null && !name.isEmpty());
        boolean hasCategory = (category != null);

        // ❗️❗️ 모든 경우의 수를 처리하도록 if-else 구조를 반드시 수정해야 합니다.
        if (hasName && hasCategory) {
            foodPage = foodRepository.findByNameContainingAndCategory(name, category, pageable);
        } else if (hasName) {
            foodPage = foodRepository.findByNameContaining(name, pageable);
        } else if (hasCategory) {
            foodPage = foodRepository.findByCategory(category, pageable);
        } else {
            // ❗️ 아무 조건도 없을 때 (ex: 앱 첫 진입) 전체 목록을 반환
            foodPage = foodRepository.findAll(pageable);
        }

        // FoodSummaryResponse::from == food -> FoodSummaryResponse.from(food)
        return foodPage.map(FoodSummaryResponse::from);
    }

    public FoodDetailResponse getFoodDetailById(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 음식을 찾을 수 없습니다."));
        return FoodDetailResponse.from(food);
    }



//    @Transactional
//    public void createFoodFromDto(FoodSummaryResponse summaryResponse) {
//
//        int roundedCarbs = (int) Math.round(summaryResponse.carbs());
//        int roundedProtein = (int) Math.round(summaryResponse.protein());
//        int roundedFat = (int) Math.round(summaryResponse.fat());
//
//        Nutrition nutrition = Nutrition.builder()
//                .carb(roundedCarbs)
//                .protein(roundedProtein)
//                .fat(roundedFat)
//                .build();
//
//        Food food = Food.builder()
//                .name(summaryResponse.name())
//                .imageUrl(summaryResponse.imageUrl())
//                .nutrition(nutrition)
//                .build();
//
//        foodRepository.save(food);
//    }

}
