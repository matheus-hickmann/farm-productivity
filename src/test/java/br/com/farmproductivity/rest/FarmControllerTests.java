package br.com.farmproductivity.rest;

import br.com.farmproductivity.domain.repository.FarmRepository;
import br.com.farmproductivity.service.farm.CreateFarmService;
import br.com.farmproductivity.service.farm.GetAllFarmsService;
import br.com.farmproductivity.service.farm.GetFarmByIdService;
import br.com.farmproductivity.service.farm.UpdateFarmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = FarmController.class)
@Import({
        GetAllFarmsService.class,
        GetFarmByIdService.class,
        CreateFarmService.class,
        UpdateFarmService.class
})
public class FarmControllerTests {

    private static final String BASE_PATH = "/";

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private FarmRepository farmRepository;

    @Test
    public void givenReceivedGetRequestOnBasePath_shouldAlwaysReturnOkStatus() {
        webClient.get()
                .uri(BASE_PATH)
                .exchange()
                .expectStatus().isOk();

    }

    @Test
    public void givenReceivedGetRequestOnInvalidFarmId_shouldAlwaysReturnNotFoundStatus() {
        webClient.get()
                .uri(BASE_PATH.concat("AnyInvalidId"))
                .exchange()
                .expectStatus().isNotFound();

    }

}
