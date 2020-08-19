package br.com.farmproductivity.rest;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.rest.models.request.FarmRequest;
import br.com.farmproductivity.rest.models.response.FarmResponse;
import br.com.farmproductivity.rest.models.response.factory.FarmResponseFactory;
import br.com.farmproductivity.service.farm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FarmController {

    @Autowired
    private GetAllFarmsService getAllFarmsService;

    @Autowired
    private GetFarmByIdService getFarmByIdService;

    @Autowired
    private CreateFarmService createFarmService;

    @Autowired
    private UpdateFarmService updateFarmService;

    @Autowired
    private DeleteFarmService deleteFarmService;

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
        FarmDocument farm = getFarmByIdService.execute(id);
        return Mono.just(FarmResponseFactory.build(farm));
    }

    @PostMapping
    public Mono<FarmResponse> createFarm(@Valid @RequestBody FarmRequest request) {
        FarmDocument createdFarm = createFarmService.execute(request.getName());
        return Mono.just(FarmResponseFactory.build(createdFarm));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity> updateFarm(@PathVariable("id") String id,
                                           @Valid @RequestBody FarmRequest request) {
        updateFarmService.execute(id, request.getName());

        return Mono.just(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity> deleteFarm(@PathVariable("id") String id) {
        deleteFarmService.execute(id);

        return Mono.just(ResponseEntity.noContent().build());
    }

}
