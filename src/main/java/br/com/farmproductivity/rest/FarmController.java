package br.com.farmproductivity.rest;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.rest.models.response.FarmResponse;
import br.com.farmproductivity.rest.models.response.factory.FarmResponseFactory;
import br.com.farmproductivity.service.GetAllFarmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FarmController {

    @Autowired
    private GetAllFarmsService getAllFarmsService;

    @GetMapping
    public Flux<FarmResponse> getFarms() {

        List<FarmDocument> farms = getAllFarmsService.execute();

        return Flux.fromIterable(
                farms.stream()
                        .map(FarmResponseFactory::build)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public Mono<FarmResponse> getFarmById(@PathVariable("id") String id) {
        return null;
    }

}
