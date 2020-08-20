package br.com.farmproductivity.rest.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldRequest {

    @NotNull(message = "Field 'name' can not be null")
    private String name;

    @NotNull(message = "Field 'hectare' can not be null")
    private Integer hectare;
}
