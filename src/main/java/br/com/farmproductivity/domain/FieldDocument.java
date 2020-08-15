package br.com.farmproductivity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldDocument {

    private String name;
    private Integer hectare;

    private List<ProductionDocument> productions;

}
