package br.com.farmproductivity.rest.models.response.factory;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.rest.models.response.FarmResponse;

import java.util.Objects;
import java.util.stream.Collectors;

public class FarmResponseFactory {

    public static FarmResponse build(FarmDocument farm) {
        return FarmResponse.builder()
                .id(farm.getId())
                .name(farm.getName())
                .build();
    }
}
