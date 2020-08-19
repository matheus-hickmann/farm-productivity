package br.com.farmproductivity.service.farm;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import br.com.farmproductivity.exception.FarmNameAlreadyInUseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateFarmService {

    @Autowired
    private GetFarmByIdService getFarmByIdService;

    @Autowired
    private FarmRepository repository;

    public void execute(String id, String name) {
        FarmDocument farm = getFarmByIdService.execute(id);

        if (name.equals(farm.getName())) {
            return;
        }

        Optional<FarmDocument> optionalFarmByName = repository.findByName(name);

        if (optionalFarmByName.isPresent()) {
            throw new FarmNameAlreadyInUseException();
        }

        farm.setName(name);
        repository.save(farm);
    }
}
