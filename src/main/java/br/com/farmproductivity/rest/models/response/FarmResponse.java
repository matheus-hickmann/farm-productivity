package br.com.farmproductivity.rest.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class FarmResponse {

    private String name;
    private BigDecimal productionCapacity;
}
