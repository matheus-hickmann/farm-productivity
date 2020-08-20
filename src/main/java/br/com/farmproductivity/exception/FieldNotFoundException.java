package br.com.farmproductivity.exception;

public class FieldNotFoundException extends BusinessException {
    private static final ErrorCode ERROR_CODE = ErrorCode.FIELD_NOT_FOUND;

    public FieldNotFoundException() {
        super(ERROR_CODE);
    }
}
