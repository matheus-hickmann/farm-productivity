package br.com.farmproductivity.service;

import br.com.farmproductivity.domain.FieldDocument;
import br.com.farmproductivity.domain.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllFieldsByFarmService {

    @Autowired
    private FieldRepository repository;

    public List<FieldDocument> execute(String farmId) {
        return repository.findByFarmId(farmId);
    }
}
