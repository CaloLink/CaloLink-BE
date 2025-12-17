package shop.calolink.domain.exception.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import shop.calolink.global.apiPayload.code.BaseSuccessCode;

@Getter
@RequiredArgsConstructor
public enum FoodSuccessCode implements BaseSuccessCode {

    FOOD_FOUND(HttpStatus.FOUND, "COMMON302_1", "음식을 찾았습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}