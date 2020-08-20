package br.com.farmproductivity.service.field;

import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.domain.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFieldService {

    @Autowired
    private GetFieldService getFieldService;

    @Autowired
    private FieldRepository repository;

    public void execute(String farmId, String id) {
        FieldDocument field = getFieldService.execute(farmId, id);

        repository.delete(field);
    }
}
