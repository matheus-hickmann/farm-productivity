package br.com.farmproductivity.service.production;

import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.domain.ProductionDocument;
import br.com.farmproductivity.domain.repository.ProductionRepository;
import br.com.farmproductivity.rest.models.request.ProductionRequest;
import br.com.farmproductivity.service.field.GetFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductionService {

    @Autowired
    private GetFieldService getFieldService;

    @Autowired
    private ProductionRepository repository;

    public ProductionDocument execute(String farmId, String fieldId, ProductionRequest request) {
        FieldDocument field = getFieldService.execute(farmId, fieldId);

        return repository.save(ProductionDocument.builder()
                .farmId(field.getFarmId())
                .fieldId(field.getId())
                .description(request.getDescription())
                .amount(request.getAmount())
                .build());
    }
}
