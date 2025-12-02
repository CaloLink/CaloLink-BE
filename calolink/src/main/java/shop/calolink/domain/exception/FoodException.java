package shop.calolink.domain.exception;

import shop.calolink.global.apiPayload.code.BaseErrorCode;
import shop.calolink.global.apiPayload.exception.GeneralException;

public class FoodException extends GeneralException {
    public FoodException(BaseErrorCode code) {
        super(code);
    }
}
