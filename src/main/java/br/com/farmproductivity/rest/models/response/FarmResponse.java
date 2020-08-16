package br.com.farmproductivity.rest.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class FarmResponse {

    private String id;
    private String name;

    private List<FieldResponse> fields;

}
