package br.com.farmproductivity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "fields")
public class FieldDocument {

    @Id
    private String id;

    private String farmId;

    private String name;
    private Integer hectare;

    private List<ProductionDocument> productions;

}
