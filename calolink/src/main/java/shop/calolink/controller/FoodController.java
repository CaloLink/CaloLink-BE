package shop.calolink.controller;


import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import shop.calolink.Category;
import shop.calolink.domain.dto.res.FoodResDto;
import shop.calolink.domain.exception.code.FoodSuccessCode;
import shop.calolink.global.apiPayload.ApiResponse;
import shop.calolink.service.FoodQueryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/foods")
public class FoodController implements FoodControllerDocs{

    private final FoodQueryService foodQueryService;

    /**
     * 음식 목록 검색 및 조회 API
     * 예시 URL: /api/foods?category=NOODLES&page=0&size=10
     */
    @GetMapping
    public ApiResponse<FoodResDto.FoodSummaryListDto> getFoodSummaryList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Category category,
            @ParameterObject Pageable pageable) {

        return ApiResponse.onSuccess(FoodSuccessCode.FOOD_FOUND, foodQueryService.searchFoods(name, category, pageable));
//        return ApiResponse.onSuccess(FoodSuccessCode.FOOD_FOUND, null);
    }

    /**
     * 음식 상세 정보 조회 API
     * 예시 URL: /api/foods/1
     */
    @GetMapping("/{id}")
    public ApiResponse<FoodResDto.FoodDetailDto> getFoodDetail(@PathVariable Long id) {

        return ApiResponse.onSuccess(FoodSuccessCode.FOOD_FOUND, foodQueryService.getFoodDetailById(id));
    }
}
