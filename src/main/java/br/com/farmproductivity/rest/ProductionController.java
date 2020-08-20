package br.com.farmproductivity.rest;

import br.com.farmproductivity.domain.ProductionDocument;
import br.com.farmproductivity.rest.models.request.ProductionRequest;
import br.com.farmproductivity.rest.models.response.ProductionResponse;
import br.com.farmproductivity.service.production.CreateProductionService;
import br.com.farmproductivity.service.production.DeleteProductionService;
import br.com.farmproductivity.service.production.GetProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/{farmId}/fields/{fieldId}/productions}")
public class ProductionController {

    @Autowired
    private GetProductionService getProductionService;

    @Autowired
    private CreateProductionService createProductionService;

    @Autowired
    private DeleteProductionService deleteProductionService;

    @PostMapping
    public Mono<ProductionResponse> createProduction(@PathVariable("farmId") String farmId,
                                                     @PathVariable("fieldId") String fieldId,
                                                     @Valid @RequestBody ProductionRequest productionRequest) {
        return null; //Out of time
    }
}
