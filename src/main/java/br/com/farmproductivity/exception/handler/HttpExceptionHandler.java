package br.com.farmproductivity.exception.handler;

import br.com.farmproductivity.exception.BusinessException;
import br.com.farmproductivity.exception.ErrorCode;
import br.com.farmproductivity.exception.factory.HttpErrorResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpExceptionHandler {

    //Business Exception
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity handleBusinessException(BusinessException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(HttpErrorResponseFactory.build(
                e.getCode(), e.getMessage())
        );
    }

    //Global Exception Handler
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
