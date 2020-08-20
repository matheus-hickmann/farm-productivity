package br.com.farmproductivity.service.field;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import br.com.farmproductivity.domain.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFieldService {

    @Autowired
    private GetFieldByIdService getFieldByIdService;

    @Autowired
    private FieldRepository repository;

    public void execute(String farmId, String id) {
        FieldDocument field = getFieldByIdService.execute(farmId, id);

        repository.delete(field);
    }
}
