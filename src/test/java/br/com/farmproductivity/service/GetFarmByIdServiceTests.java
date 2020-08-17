package br.com.farmproductivity.service;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import br.com.farmproductivity.exception.FarmNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GetFarmByIdServiceTests {

    private static final FarmDocument FARM = FarmDocument.builder()
            .id("id")
            .name("testName")
            .build();

    @InjectMocks
    private GetFarmByIdService service;

    @Mock
    private FarmRepository repository;

    @Test
    public void givenFarmExists_shouldReturnFarm() {
        when(repository.findById(anyString())).thenReturn(Optional.of(FARM));

        FarmDocument result = service.execute("id");
        assertEquals("Result should be equals to Mock", result, FARM);
    }

    @Test
    public void givenFarmDoesNotExists_shouldThrowFarmNotFoundException() {
        when(repository.findById(anyString())).thenReturn(Optional.empty());

        assertThrows(FarmNotFoundException.class, () -> {
            service.execute("anyInvalidId");
        });
    }
}
