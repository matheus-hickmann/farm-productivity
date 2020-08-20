package br.com.farmproductivity.service.production;

import br.com.farmproductivity.domain.ProductionDocument;
import br.com.farmproductivity.domain.repository.ProductionRepository;
import br.com.farmproductivity.exception.ProductionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductionService {

    @Autowired
    private ProductionRepository repository;

    public ProductionDocument execute(String farmId, String fieldId, String id) {
        Optional<ProductionDocument> optionalProduction = repository.findByFarmIdAndFieldIdAndId(farmId, fieldId, id);

        if (!optionalProduction.isPresent()) {
            throw new ProductionNotFoundException();
        }

        return optionalProduction.get();
    }
}
