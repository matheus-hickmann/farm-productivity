package br.com.farmproductivity.exception;

public class ProductionNotFoundException extends BusinessException {
    private static final ErrorCode ERROR_CODE = ErrorCode.PRODUCTION_NOT_FOUND;

    public ProductionNotFoundException() {
        super(ERROR_CODE);
    }
}
