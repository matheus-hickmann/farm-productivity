package br.com.farmproductivity.exception.factory;

import br.com.farmproductivity.rest.models.response.HttpErrorResponse;

public class HttpErrorResponseFactory {

    private HttpErrorResponseFactory() {}

    public static HttpErrorResponse build(String code, String message) {
        return HttpErrorResponse.builder()
                .code(code)
                .message(message)
                .build();
    }

}