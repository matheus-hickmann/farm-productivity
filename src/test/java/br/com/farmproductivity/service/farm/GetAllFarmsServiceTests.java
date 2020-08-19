package br.com.farmproductivity.service.farm;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.repository.FarmRepository;
import br.com.farmproductivity.service.farm.GetAllFarmsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(MockitoExtension.class)
public class GetAllFarmsServiceTests {

    @InjectMocks
    GetAllFarmsService service;

    @Mock
    FarmRepository repository;

    @Test
    public void givenRepositoryDoesNotFindAnyFarm_shouldReturnEmptyList() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        List<FarmDocument> result = service.execute();

        assertTrue("Result should be empty when there isn't any farm", result.isEmpty());
    }


    @Test
    public void givenRepositoryDoesFindFarms_shouldReturnSameAmountList() {
        int listSize = 3;

        when(repository.findAll()).thenReturn(Arrays.asList(
                mock(FarmDocument.class),mock(FarmDocument.class),mock(FarmDocument.class)
        ));

        List<FarmDocument> result = service.execute();

        assertEquals("Result should be list with 3 items", result.size(), listSize);
    }

}
