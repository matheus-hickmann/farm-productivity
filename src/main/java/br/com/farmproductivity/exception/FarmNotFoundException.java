package br.com.farmproductivity.exception;

public class FarmNotFoundException extends BusinessException {

    private static final ErrorCode ERROR_CODE = ErrorCode.FARM_NOT_FOUND;

    public FarmNotFoundException() {
        super(ERROR_CODE);
    }
}
