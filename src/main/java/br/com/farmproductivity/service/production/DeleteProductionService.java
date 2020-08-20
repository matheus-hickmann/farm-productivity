package br.com.farmproductivity.service.production;

import br.com.farmproductivity.domain.ProductionDocument;
import br.com.farmproductivity.domain.repository.ProductionRepository;
import br.com.farmproductivity.exception.ProductionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductionService {

    @Autowired
    private GetProductionService getProductionService;

    @Autowired
    private ProductionRepository repository;

    public void execute(String farmId, String fieldId, String id) {
        ProductionDocument production = getProductionService.execute(farmId, fieldId, id);

        if (!production.getFarmId().equals(farmId) || !production.getFieldId().equals(fieldId)) {
            throw new ProductionNotFoundException();
        }

        repository.delete(production);
    }
}
