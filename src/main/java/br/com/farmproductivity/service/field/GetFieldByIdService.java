package br.com.farmproductivity.service.field;

import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.domain.repository.FieldRepository;
import br.com.farmproductivity.exception.FieldNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetFieldByIdService {

    @Autowired
    private FieldRepository repository;

    public FieldDocument execute(String farmId, String id) {
        Optional<FieldDocument> optionalField = repository.findByFarmIdAndId(farmId, id);

        if (!optionalField.isPresent()) {
            throw new FieldNotFoundException();
        }

        return optionalField.get();
    }
}
