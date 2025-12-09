package shop.calolink.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import shop.calolink.Category;
import shop.calolink.domain.dto.res.FoodResDto;
import shop.calolink.global.apiPayload.ApiResponse;

@Component
public interface FoodControllerDocs {

    @Operation(
            summary = "여러 음식을 정보 미리 보기 By 윤정우 (개발 완료)",
            description = "음식 이름 또는 카테고리에 맞는 음식 리스트를 조회합니다.\n\n"
    )
    ApiResponse<FoodResDto.FoodSummaryListDto> getFoodSummaryList(@RequestParam(required = false) String name,
                                                              @RequestParam(required = false) Category category,
                                                              Pageable pageable);

    @Operation(
            summary = "음식 상세정보 조회 By 윤정우 (개발 중)",
            description = "음식ID를 경로변수로 받아서 음식에 대한 영양정보를 조회합니다.\n\n" +
                    "각 사이트에 대한 가격을 크롤링해서 데이터베이스에 넣어줘야합니다."
    )
    ApiResponse<FoodResDto.FoodDetailDto> getFoodDetail(@PathVariable Long id);
}
