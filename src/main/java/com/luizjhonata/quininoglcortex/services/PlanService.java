package com.luizjhonata.quininoglcortex.services;

import com.luizjhonata.quininoglcortex.models.Plan;
import com.luizjhonata.quininoglcortex.repositories.PlanRepository;
import com.luizjhonata.quininoglcortex.dto.PlanDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanDTO insertPlan(@RequestBody PlanDTO planDTO) {
        Plan newPlan = new Plan(null, planDTO.getName(), planDTO.getFreeMinutes(), planDTO.getAdditionalTariff());
        planRepository.save(newPlan);
        return new PlanDTO(newPlan);
    }

    @Transactional
    public PlanDTO updatePlan(@PathVariable PlanDTO plan) {
        if(planRepository.existsById(plan.getId())) {
            Plan updatePlan = planRepository.getReferenceById(plan.getId());
            updatePlan.setId(plan.getId());
            if (updatePlan.getName() == null || updatePlan.getName() == "" ) {
                plan.setName(updatePlan.getName());
            }
            if (updatePlan.getFreeMinutes() == null || updatePlan.getFreeMinutes() == 0 ) {
                plan.setFreeMinutes(updatePlan.getFreeMinutes());
            }
            if (updatePlan.getAdditionalTariff() == null || updatePlan.getAdditionalTariff() == 0 ) {
                plan.setAdditionalTariff(updatePlan.getAdditionalTariff());
            }
            updatePlan.setName(plan.getName());
            updatePlan.setFreeMinutes(plan.getFreeMinutes());
            updatePlan.setAdditionalTariff(plan.getAdditionalTariff());
            planRepository.save(updatePlan);
        }
        return plan;
    }

    @Transactional
    public void deletePlanById(Long id) {
        if (planRepository.existsById(id)) {
            planRepository.deleteById(id);
        }
    }

    public List<PlanDTO> findAll() {
        List<Plan> listPlan = planRepository.findAll();
        return listPlan.stream().map(x -> new PlanDTO(x)).collect(Collectors.toList());
    }
}
