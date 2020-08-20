package br.com.farmproductivity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error ocurred"),
    DUPLICATED_FARM_NAME(HttpStatus.FORBIDDEN, "Farm name cannot be duplicated"),
    DUPLICATED_FIELD_NAME(HttpStatus.FORBIDDEN, "Field name cannot be duplicated for the same farm"),
    FARM_NOT_FOUND(HttpStatus.NOT_FOUND, "Farm not found"),
    FIELD_NOT_FOUND(HttpStatus.NOT_FOUND, "Field not found");

    private HttpStatus httpStatus;
    private String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }


}
