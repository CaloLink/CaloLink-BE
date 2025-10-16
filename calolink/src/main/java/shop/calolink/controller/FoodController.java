package shop.calolink.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.calolink.Category;
import shop.calolink.domain.dto.FoodDetailResponse;
import shop.calolink.domain.dto.FoodSummaryResponse;
import shop.calolink.service.FoodService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    /**
     * 음식 목록 검색 및 조회 API
     * 예시 URL: /api/foods?category=NOODLES&page=0&size=10
     */
    @GetMapping
    public ResponseEntity<Page<FoodSummaryResponse>> getFoodSummary(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Category category,
            Pageable pageable) {
        Page<FoodSummaryResponse> foods = foodService.searchFoods(name, category, pageable);

        return ResponseEntity.ok(foods);
    }

    /**
     * 음식 상세 정보 조회 API
     * 예시 URL: /api/foods/1
     */
    @GetMapping("/{id}")
    public ResponseEntity<FoodDetailResponse> getFoodDetail(@PathVariable Long id) {
        FoodDetailResponse foodDetail = foodService.getFoodDetailById(id);
        return ResponseEntity.ok(foodDetail);
    }
}
