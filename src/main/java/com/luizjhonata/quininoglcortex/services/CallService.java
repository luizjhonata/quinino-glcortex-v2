package com.luizjhonata.quininoglcortex.services;

import com.luizjhonata.quininoglcortex.controlleradvice.PlanNotFoundException;
import com.luizjhonata.quininoglcortex.enums.Ddd;
import com.luizjhonata.quininoglcortex.models.Call;
import com.luizjhonata.quininoglcortex.models.Plan;
import com.luizjhonata.quininoglcortex.models.Tariff;
import com.luizjhonata.quininoglcortex.repositories.PlanRepository;
import com.luizjhonata.quininoglcortex.repositories.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallService {

    @Autowired
    private TariffRepository tariffRepository;

    @Autowired
    private PlanRepository planRepository;

    public Call calculateCallCost(Ddd origin, Ddd destiny, Double time, Long planId) throws Exception {
        Tariff tariff = tariffRepository.findByOriginAndDestiny(origin, destiny);
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new PlanNotFoundException("Plan not found"));

        Double costWithoutPlan = time * tariff.getPricePerMinute();
        Double costWithPlan = 0.0;

        if(time > plan.getFreeMinutes()) {
            costWithPlan = (time - plan.getFreeMinutes()) * (tariff.getPricePerMinute() * plan.getAdditionalTariff());
        }

        Call call = new Call();
        call.setOrigin(origin);
        call.setDestiny(destiny);
        call.setTime(time);
        call.setPlan(plan);
        call.setCostWithoutPlan(costWithoutPlan);
        call.setCostWithPlan(costWithPlan);

        return call;
    }
}
