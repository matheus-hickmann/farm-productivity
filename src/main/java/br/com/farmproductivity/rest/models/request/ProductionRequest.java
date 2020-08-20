package br.com.farmproductivity.rest.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductionRequest {

    @NotNull(message = "Field 'description' can not be null")
    private String description;

    @NotNull(message = "Field 'amount' can not be null")
    private BigDecimal amount;

}
