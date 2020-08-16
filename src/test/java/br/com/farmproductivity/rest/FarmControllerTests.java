package br.com.farmproductivity.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = FarmController.class)
public class FarmControllerTests {

    private static final String BASE_PATH = "/";

    @Autowired
    private WebTestClient webClient;

    @Test
    public void givenReceivedGetRequestOnBasePath_shouldAlwaysReturnOkStatus() {
        webClient.get()
                .uri(BASE_PATH)
                .exchange()
                .expectStatus().isOk();

    }


}
