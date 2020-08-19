package br.com.farmproductivity.service.farm;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllFarmsService {

    @Autowired
    private FarmRepository repository;

    public List<FarmDocument> execute() {
        return repository.findAll();
    }

}
