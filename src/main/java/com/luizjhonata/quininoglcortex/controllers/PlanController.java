package com.luizjhonata.quininoglcortex.controllers;

import com.luizjhonata.quininoglcortex.services.PlanService;
import dto.PlanDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/plans")
public class PlanController {

    private final PlanService planService;


    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<PlanDTO> insertPlan(@RequestBody PlanDTO newPlan) {
        planService.inserPlan(newPlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlan);
    }
}
