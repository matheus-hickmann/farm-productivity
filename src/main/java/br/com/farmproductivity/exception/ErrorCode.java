package br.com.farmproductivity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error ocurred"),
    DUPLICATED_FARM_NAME(HttpStatus.FORBIDDEN, "Farm name cannot be duplicated"),
    FARM_NOT_FOUND(HttpStatus.NOT_FOUND, "Farm not found");

    private HttpStatus httpStatus;
    private String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }


}
