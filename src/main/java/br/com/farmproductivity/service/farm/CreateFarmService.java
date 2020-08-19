package br.com.farmproductivity.service.farm;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import br.com.farmproductivity.exception.FarmNameAlreadyInUseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateFarmService {

    @Autowired
    private FarmRepository repository;

    public FarmDocument execute(String name) {
        Optional<FarmDocument> optionalFarm = repository.findByName(name);

        if (optionalFarm.isPresent()) {
            throw new FarmNameAlreadyInUseException();
        }

        return repository.save(FarmDocument.builder().name(name).build());
    }

}
