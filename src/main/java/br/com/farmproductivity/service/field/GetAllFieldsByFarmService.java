package br.com.farmproductivity.service.field;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.domain.repository.FieldRepository;
import br.com.farmproductivity.service.farm.GetFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllFieldsByFarmService {

    @Autowired
    private GetFarmService getFarmService;

    @Autowired
    private FieldRepository repository;

    public List<FieldDocument> execute(String farmId) {
        FarmDocument farm = getFarmService.execute(farmId);
        return repository.findByFarmId(farm.getId());
    }
}
