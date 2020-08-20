package br.com.farmproductivity.rest;

import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.rest.models.request.FieldRequest;
import br.com.farmproductivity.rest.models.response.FieldResponse;
import br.com.farmproductivity.rest.models.response.factory.FieldResponseFactory;
import br.com.farmproductivity.service.field.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/{farmId}/fields")
public class FieldController {

    @Autowired
    private GetAllFieldsByFarmService getAllFieldsByFarmService;

    @Autowired
    private CreateFieldService createFieldService;

    @Autowired
    private DeleteFieldService deleteFieldService;

    @Autowired
    private GetFieldService getFieldService;

    @Autowired
    private UpdateFieldService updateFieldService;

    @GetMapping
    public Flux<FieldResponse> getFieldsByFarmId(@PathVariable("farmId") String farmId) {
        List<FieldDocument> farmFields = getAllFieldsByFarmService.execute(farmId);

        return Flux.fromIterable(farmFields.stream().map(FieldResponseFactory::build).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Mono<FieldResponse> getFieldByFarmIdAndId(@PathVariable("farmId") String farmId,
                                                     @PathVariable("id") String id) {
        FieldDocument field = getFieldService.execute(farmId, id);

        return Mono.just(FieldResponseFactory.build(field));
    }

    @PostMapping
    public Mono<FieldResponse> createField(@PathVariable("farmId") String farmId,
                                           @Valid @RequestBody FieldRequest request) {
        FieldDocument field = createFieldService.execute(farmId, request.getName(), request.getHectare());

        return Mono.just(FieldResponseFactory.build(field));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity> updateField(@PathVariable("farmId") String farmId,
                                            @PathVariable("id") String id,
                                            @Valid @RequestBody FieldRequest request) {
        updateFieldService.execute(farmId, id, request);

        return Mono.just(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity> deleteField(@PathVariable("farmId") String farmId,
                                            @PathVariable("id") String id) {
        deleteFieldService.execute(farmId, id);

        return Mono.just(ResponseEntity.noContent().build());
    }

}
