package com.luizjhonata.quininoglcortex.service;

import com.luizjhonata.quininoglcortex.models.Tariff;
import com.luizjhonata.quininoglcortex.repositories.TariffRepository;
import com.luizjhonata.quininoglcortex.services.TariffService;
import dto.TariffDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TariffServiceTest {

    @Mock
    TariffService tariffService;

    @Mock
    TariffRepository tariffRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tariffService = new TariffService(tariffRepository);
    }

    @Test
    public void insertTariffTest() {
        //given
        TariffDTO tariffDTO = new TariffDTO(1L, "SP", "RJ", 1.5);
        Tariff tariff = new Tariff(null, "SP", "RJ", 1.5);

        //when
        when(tariffRepository.save(any(Tariff.class))).thenReturn(tariff);

        TariffDTO result = tariffService.insertTariff(tariffDTO);

        //then
        assertEquals(tariffDTO.getOrigin(), result.getOrigin());
        assertEquals(tariffDTO.getDestiny(), result.getDestiny());
        assertEquals(tariffDTO.getPricePerMinute(), result.getPricePerMinute());
    }

    @Test
    public void updateTariffTest() {
        //given
        TariffDTO tariffDTO = new TariffDTO(1L, "SP", "RJ", 1.5);
        Tariff existingTariff = new Tariff(1L, "SP", "RJ", 1.5);

        //when
        when(tariffRepository.existsById(tariffDTO.getId())).thenReturn(true);
        when(tariffRepository.getReferenceById(tariffDTO.getId())).thenReturn(existingTariff);
        TariffDTO result = tariffService.updateTariff(tariffDTO);

        //then
        assertEquals(tariffDTO.getOrigin(), result.getOrigin());
        assertEquals(tariffDTO.getDestiny(), result.getDestiny());
        assertEquals(tariffDTO.getPricePerMinute(), result.getPricePerMinute());
    }

    @Test
    public void deleteTariffByIdTest() {
        //given
        Long tariffId = 1L;
        Tariff tariff = new Tariff(1L, "SP", "RJ", 1.5);

        //when
        when(tariffRepository.findById(tariffId)).thenReturn(java.util.Optional.of(tariff));

        tariffService.deleteTariffById(tariffId);

        //then
        Mockito.verify(tariffRepository, Mockito.times(1)).deleteById(tariffId);
    }

}