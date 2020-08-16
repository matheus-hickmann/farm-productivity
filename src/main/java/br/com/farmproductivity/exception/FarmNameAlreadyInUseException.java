package br.com.farmproductivity.exception;

public class FarmNameAlreadyInUseException extends BusinessException{

    private static final ErrorCode ERROR_CODE = ErrorCode.DUPLICATED_FARM_NAME;

    public FarmNameAlreadyInUseException() {
        super(ERROR_CODE);
    }
}
