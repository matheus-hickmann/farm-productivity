package br.com.farmproductivity.rest.models.response.factory;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.rest.models.response.FarmResponse;

public class FarmResponseFactory {

    public static FarmResponse build(FarmDocument farm) {
        return FarmResponse.builder()
                .id(farm.getId())
                .name(farm.getName())
                .build();
    }
}
