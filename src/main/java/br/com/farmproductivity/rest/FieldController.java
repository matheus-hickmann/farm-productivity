package br.com.farmproductivity.rest;

import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.rest.models.response.FieldResponse;
import br.com.farmproductivity.rest.models.response.factory.FieldResponseFactory;
import br.com.farmproductivity.service.GetAllFieldsByFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/{farmId}/fields")
public class FieldController {

    @Autowired
    private GetAllFieldsByFarmService getAllFieldsByFarmService;

    @GetMapping
    public Flux<FieldResponse> getFieldsByFarmId(@PathVariable("farmId") String farmId) {
        List<FieldDocument> farmFields = getAllFieldsByFarmService.execute(farmId);

        return Flux.fromIterable(farmFields.stream().map(FieldResponseFactory::build).collect(Collectors.toList()));
    }
}
