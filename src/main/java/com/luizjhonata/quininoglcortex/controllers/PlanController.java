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
    @PutMapping(value = "/{id}")
    public ResponseEntity<PlanDTO> updatePlan(
            @PathVariable Long id, @RequestBody PlanDTO plan) {
        planService.updatePlan(plan);
        return ResponseEntity.ok(plan);
    }

    @DeleteMapping("/{id}")
    public void deletePlanById(@PathVariable("id") Long id) {
        planService.deletePlanById(id);
    }
}