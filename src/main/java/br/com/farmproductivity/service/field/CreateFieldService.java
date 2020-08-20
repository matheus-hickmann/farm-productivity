package br.com.farmproductivity.service.field;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.domain.repository.FieldRepository;
import br.com.farmproductivity.exception.FarmNameAlreadyInUseException;
import br.com.farmproductivity.service.farm.GetFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateFieldService {

    @Autowired
    public GetFarmService getFarmService;

    @Autowired
    private FieldRepository repository;

    public FieldDocument execute(String farmId, String name, Integer hectare) {
        FarmDocument farm = getFarmService.execute(farmId);
        Optional<FieldDocument> optionalField = repository.findByFarmIdAndName(farmId, name);

        if (optionalField.isPresent()) {
            throw new FarmNameAlreadyInUseException();
        }

        return repository.save(
                FieldDocument.builder()
                        .farmId(farm.getId())
                        .hectare(hectare)
                        .name(name)
                .build());
    }

}
