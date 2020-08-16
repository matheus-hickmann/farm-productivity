package br.com.farmproductivity.rest;

import br.com.farmproductivity.domain.repository.FarmRepository;
import br.com.farmproductivity.service.GetAllFarmsService;
import br.com.farmproductivity.service.GetFarmByIdService;
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
        GetFarmByIdService.class
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


}
