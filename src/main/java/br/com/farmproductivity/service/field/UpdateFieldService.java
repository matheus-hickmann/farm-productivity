package br.com.farmproductivity.service.field;

import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.domain.repository.FieldRepository;
import br.com.farmproductivity.exception.FieldNameAlreadyInUseException;
import br.com.farmproductivity.rest.models.request.FieldRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateFieldService {

    @Autowired
    private GetFieldByIdService getFieldByIdService;

    @Autowired
    private FieldRepository repository;

    public void execute(String farmId, String id, FieldRequest request) {
        FieldDocument field = getFieldByIdService.execute(farmId, id);

        if (request.getName().equals(field.getName())) {
            return;
        }

        Optional<FieldDocument> optionalField = repository.findByFarmIdAndName(farmId, request.getName());

        if (optionalField.isPresent()) {
            throw new FieldNameAlreadyInUseException();
        }

        field.setName(request.getName());
        field.setHectare(request.getHectare());

        repository.save(field);
    }
}
