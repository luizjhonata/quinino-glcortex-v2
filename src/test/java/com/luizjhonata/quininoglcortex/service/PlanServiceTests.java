package com.luizjhonata.quininoglcortex.service;

import com.luizjhonata.quininoglcortex.models.Plan;
import com.luizjhonata.quininoglcortex.repositories.PlanRepository;
import com.luizjhonata.quininoglcortex.services.PlanService;
import com.luizjhonata.quininoglcortex.dto.PlanDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class PlanServiceTests {

    @Mock
    private PlanService planService;

    @Mock
    private PlanRepository planRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        planService = new PlanService(planRepository);
    }

    @Test
    void testInsertPlan() {
        // Criar uma instância do DTO de plano
        PlanDTO planDTO = new PlanDTO(1L, "Plano Teste", 100.0, 1.5);

        // Mock do retorno do método save do repositório
        when(planRepository.save(any(Plan.class))).thenAnswer(invocation -> {
            Plan newPlan = invocation.getArgument(0);
            newPlan.setId(1L); // Define um ID para o novo plano
            return newPlan;
        });

        // Chama o método insertPlan e verifica se o DTO retornado tem o ID correto
        PlanDTO result = planService.insertPlan(planDTO);
        assertEquals(1L, result.getId());
    }

    @Test
    void testUpdatePlan() {
        // Criar uma instância do DTO de plano com um ID existente
        PlanDTO planDTO = new PlanDTO(1L, "Plano Teste", 100.0, 1.5);

        // Mock do método existsById do repositório
        when(planRepository.existsById(planDTO.getId())).thenReturn(true);

        // Mock do método getReferenceById do repositório
        Plan existingPlan = new Plan(1L, "Plano Existente", 50.0, 1.0);
        when(planRepository.getReferenceById(planDTO.getId())).thenReturn(existingPlan);

        // Chama o método updatePlan e verifica se o nome do plano existente foi atualizado
        PlanDTO result = planService.updatePlan(planDTO);
        assertEquals(planDTO.getName(), existingPlan.getName());
    }

    @Test
    void testDeletePlanById() {
        // Mock do método existsById do repositório
        when(planRepository.existsById(1L)).thenReturn(true);

        // Chama o método deletePlanById e verifica se o método deleteById do repositório foi chamado
        planService.deletePlanById(1L);
        verify(planRepository, times(1)).deleteById(1L);
    }

}