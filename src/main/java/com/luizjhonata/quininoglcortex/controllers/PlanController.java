package com.luizjhonata.quininoglcortex.controllers;

import com.luizjhonata.quininoglcortex.services.PlanService;
import com.luizjhonata.quininoglcortex.dto.PlanDTO;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Insert a new Plan")
    @PostMapping
    public ResponseEntity<PlanDTO> insertPlan(@RequestBody PlanDTO newPlan) {
        planService.insertPlan(newPlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlan);
    }
    @Operation(summary = "Update Plan data")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PlanDTO> updatePlan(
            @PathVariable Long id, @RequestBody PlanDTO plan) {
        planService.updatePlan(plan);
        return ResponseEntity.ok(plan);
    }

    @Operation(summary = "Delete a plan")
    @DeleteMapping("/{id}")
    public void deletePlanById(@PathVariable("id") Long id) {
        planService.deletePlanById(id);
    }
}