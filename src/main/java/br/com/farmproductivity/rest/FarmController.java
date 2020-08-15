package br.com.farmproductivity.rest;

import br.com.farmproductivity.rest.models.response.FarmResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@RestController
public class FarmController {

    @GetMapping
    public Flux<FarmResponse> getFarms() {
        return Flux.fromIterable(
                Arrays.asList(
                        FarmResponse.builder().build(),
                        FarmResponse.builder().build()
                )
        );
    }

}
