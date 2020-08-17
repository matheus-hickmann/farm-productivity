package br.com.farmproductivity.rest.models.response.factory;

import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.rest.models.response.FieldResponse;

public class FieldResponseFactory {

    public static FieldResponse build(FieldDocument document) {
        return FieldResponse.builder()
                .id(document.getId())
                .name(document.getName())
                .hectare(document.getHectare())
                .build();
    }
}
