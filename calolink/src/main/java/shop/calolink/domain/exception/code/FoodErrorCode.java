package shop.calolink.domain.exception.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import shop.calolink.global.apiPayload.code.BaseErrorCode;

@Getter
@RequiredArgsConstructor
public enum FoodErrorCode implements BaseErrorCode {

    FOOD_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON404_1", "해당 음식을 찾을 수 없습니다."),
    FOOD_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON404_2", "이미지를 불러올 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
