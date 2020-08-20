package br.com.farmproductivity.exception;

public class FieldNameAlreadyInUseException extends BusinessException{

    private static final ErrorCode ERROR_CODE = ErrorCode.DUPLICATED_FIELD_NAME;

    public FieldNameAlreadyInUseException() {
        super(ERROR_CODE);
    }
}
