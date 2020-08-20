package br.com.farmproductivity.service.farm;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFarmService {

    @Autowired
    private GetFarmService getFarmService;

    @Autowired
    private FarmRepository repository;

    public void execute(String id) {
        FarmDocument farm = getFarmService.execute(id);

        repository.delete(farm);
    }
}
