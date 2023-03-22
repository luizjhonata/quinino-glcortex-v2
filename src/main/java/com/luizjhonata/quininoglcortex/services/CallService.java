package com.luizjhonata.quininoglcortex.services;

import com.luizjhonata.quininoglcortex.controlleradvice.PlanNotFoundException;
import com.luizjhonata.quininoglcortex.controlleradvice.TariffNotFoundException;
import com.luizjhonata.quininoglcortex.models.Call;
import com.luizjhonata.quininoglcortex.models.Plan;
import com.luizjhonata.quininoglcortex.models.Tariff;
import com.luizjhonata.quininoglcortex.repositories.PlanRepository;
import com.luizjhonata.quininoglcortex.repositories.TariffRepository;
import org.springframework.stereotype.Service;

@Service
public class CallService {

    private final TariffRepository tariffRepository;
    private final PlanRepository planRepository;

    public CallService(final TariffRepository tariffRepository, final PlanRepository planRepository) {
        this.tariffRepository = tariffRepository;
        this.planRepository = planRepository;
    }

    public Call calculateCallCost(String origin, String destiny, Double time, Long planId) throws RuntimeException {
        Tariff tariff = tariffRepository.findByOriginAndDestiny(origin, destiny).orElseThrow(()
        -> new TariffNotFoundException
                ("Não é possível realizar chamada do " + origin + " para o " + destiny + " pela Q.uinino Telefonia"));
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new PlanNotFoundException());

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
