package br.com.farmproductivity.rest.models.request;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class FarmRequest {

    @NotNull(message = "Property 'name' can´t be null")
    @NotBlank(message = "Property 'name' can't be empty")
    private String name;

}
