package br.com.farmproductivity.service;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import br.com.farmproductivity.exception.FarmNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetFarmByIdService {

    @Autowired
    private FarmRepository repository;

    public FarmDocument execute(String id) {
        Optional<FarmDocument> optionalFarmDocument = repository.findById(id);

        if (!optionalFarmDocument.isPresent()) {
            throw new FarmNotFoundException();
        }

        return optionalFarmDocument.get();
    }
}
