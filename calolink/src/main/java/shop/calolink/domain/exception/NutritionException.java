package shop.calolink.domain.exception;

import shop.calolink.global.apiPayload.code.BaseErrorCode;
import shop.calolink.global.apiPayload.exception.GeneralException;

public class NutritionException extends GeneralException {
    public NutritionException(BaseErrorCode code) {
        super(code);
    }
}
