package com.luizjhonata.quininoglcortex.service;

import com.luizjhonata.quininoglcortex.controlleradvice.PlanNotFoundException;
import com.luizjhonata.quininoglcortex.controlleradvice.TariffNotFoundException;
import com.luizjhonata.quininoglcortex.models.Call;
import com.luizjhonata.quininoglcortex.models.Plan;
import com.luizjhonata.quininoglcortex.models.Tariff;
import com.luizjhonata.quininoglcortex.repositories.PlanRepository;
import com.luizjhonata.quininoglcortex.repositories.TariffRepository;
import com.luizjhonata.quininoglcortex.services.CallService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CallServiceTests {

    @Test
    void calculateCallCostWithoutPlanTest() {
        // Given
        Tariff tariff = mock(Tariff.class);
        when(tariff.getPricePerMinute()).thenReturn(1.9);

        Plan plan = mock(Plan.class);
        when(plan.getName()).thenReturn("FaleMais 30");
        when(plan.getFreeMinutes()).thenReturn(30.0);
        when(plan.getAdditionalTariff()).thenReturn(1.1);

        TariffRepository tariffRepository = mock(TariffRepository.class);
        when(tariffRepository.findByOriginAndDestiny("011", "016")).thenReturn(Optional.of(tariff));

        PlanRepository planRepository = mock(PlanRepository.class);
        when(planRepository.findById(1L)).thenReturn(Optional.of(plan));

        CallService callService = new CallService(tariffRepository, planRepository);

        // When
        Call call = callService.calculateCallCost("011", "016", 20.0, 1L);

        // Then
        assertNotNull(call);
        assertEquals("011", call.getOrigin());
        assertEquals("016", call.getDestiny());
        assertEquals(20.0, call.getTime());
        assertEquals(plan, call.getPlan());
        assertEquals(38.0, call.getCostWithoutPlan());
        assertEquals(0.0, call.getCostWithPlan());
    }

    @Test
    void calculateCallCostWithPlanTest() {
        // Given
        TariffRepository tariffRepository = mock(TariffRepository.class);
        PlanRepository planRepository = mock(PlanRepository.class);
        CallService callService = new CallService(tariffRepository, planRepository);

        Tariff tariff = new Tariff(3L, "011", "017", 1.7);
        when(tariffRepository.findByOriginAndDestiny("011", "017")).thenReturn(Optional.of(tariff));

        Plan plan = new Plan(2L, "FaleMais 60", 60.0, 1.1);
        when(planRepository.findById(2L)).thenReturn(Optional.of(plan));

        // When
        Call call = callService.calculateCallCost("011", "017", 80.0, 2L);

        // Then
        assertEquals("011", call.getOrigin());
        assertEquals("017", call.getDestiny());
        assertEquals(80.0, call.getTime(), 0.0);
        assertEquals(plan, call.getPlan());
        assertEquals(136.0, call.getCostWithoutPlan(), 0.0);
        assertEquals(37.400000000000006, call.getCostWithPlan(), 0.0);
    }

    @Test
    void calculateCallCostTariffNotFoundTest() {
        // Given
        TariffRepository tariffRepository = mock(TariffRepository.class);
        PlanRepository planRepository = mock(PlanRepository.class);
        CallService callService = new CallService(tariffRepository, planRepository);

        when(tariffRepository.findByOriginAndDestiny("011", "018")).thenReturn(Optional.empty());

        // When
        assertThrows(TariffNotFoundException.class, () -> {
            callService.calculateCallCost("011", "018", 20.0, 1L);
        });
    }

    @Test
    void calculateCallCostPlanNotFoundTest() {
        // Given
        TariffRepository tariffRepository = mock(TariffRepository.class);
        PlanRepository planRepository = mock(PlanRepository.class);
        CallService callService = new CallService(tariffRepository, planRepository);
        Tariff tariff = new Tariff(8L, "018", "011", 2.0);
        when(tariffRepository.findByOriginAndDestiny("018", "011")).thenReturn(Optional.of(tariff));

        when(planRepository.findById(99L)).thenReturn(Optional.empty());

        // When
        assertThrows(PlanNotFoundException.class, () -> {
            callService.calculateCallCost("018", "011", 10.0, 99L);
        });
    }
}
