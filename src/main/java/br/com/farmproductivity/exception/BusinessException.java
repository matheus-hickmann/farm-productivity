package br.com.farmproductivity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private String code;
    private HttpStatus httpStatus;
    private String message;

    public BusinessException(ErrorCode errorCode) {
        this.code = errorCode.toString();
        this.httpStatus = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
    }
}
