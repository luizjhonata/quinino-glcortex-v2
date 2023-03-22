package com.luizjhonata.quininoglcortex.services;

import com.luizjhonata.quininoglcortex.models.Plan;
import com.luizjhonata.quininoglcortex.repositories.PlanRepository;
import dto.PlanDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanDTO inserPlan(@RequestBody PlanDTO planDTO) {
        Plan newPlan = new Plan(null, planDTO.getName(), planDTO.getFreeMinutes(), planDTO.getAdditionalTariff());
        planRepository.save(newPlan);
        return new PlanDTO(newPlan);
    }
}
