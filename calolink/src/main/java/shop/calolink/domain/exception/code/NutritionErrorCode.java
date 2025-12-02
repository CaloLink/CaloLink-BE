package shop.calolink.domain.exception.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import shop.calolink.global.apiPayload.code.BaseErrorCode;

@Getter
@RequiredArgsConstructor
public enum NutritionErrorCode implements BaseErrorCode {

    NUTRITION_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON404_1", "영양성분을 불러올 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
