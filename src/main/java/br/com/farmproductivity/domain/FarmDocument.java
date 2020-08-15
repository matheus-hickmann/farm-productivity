package br.com.farmproductivity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FarmDocument {

    private String name;
    private BigDecimal productionCapacity;

    private List<FieldDocument> fields;

}
