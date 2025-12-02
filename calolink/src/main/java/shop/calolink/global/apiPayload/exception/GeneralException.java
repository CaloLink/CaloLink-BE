package shop.calolink.global.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shop.calolink.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;
}
