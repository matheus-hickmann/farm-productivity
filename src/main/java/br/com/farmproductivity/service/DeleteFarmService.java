package br.com.farmproductivity.service;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFarmService {

    @Autowired
    private GetFarmByIdService getFarmByIdService;

    @Autowired
    private FarmRepository repository;

    public void execute(String id) {
        FarmDocument farm = getFarmByIdService.execute(id);

        repository.delete(farm);
    }
}
