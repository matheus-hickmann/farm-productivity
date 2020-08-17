package br.com.farmproductivity.rest.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HttpErrorResponse {
    private String code;
    private String message;
}
