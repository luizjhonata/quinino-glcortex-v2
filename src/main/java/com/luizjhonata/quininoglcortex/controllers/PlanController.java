package com.luizjhonata.quininoglcortex.controllers;

import com.luizjhonata.quininoglcortex.services.PlanService;
import com.luizjhonata.quininoglcortex.dto.PlanDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @Operation(summary = "Insert a new Plan")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @PostMapping
    public ResponseEntity<PlanDTO> insertPlan(@RequestBody PlanDTO newPlan) {
        planService.insertPlan(newPlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlan);
    }
    @Operation(summary = "Update Plan data")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @PutMapping
    public ResponseEntity<PlanDTO> updatePlan(@RequestBody PlanDTO plan) {
        planService.updatePlan(plan);
        return ResponseEntity.ok(plan);
    }

    @Operation(summary = "Delete a plan")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @DeleteMapping("/{id}")
    public void deletePlanById(@PathVariable("id") Long id) {
        planService.deletePlanById(id);
    }


    @Operation(summary = "Get a list off all plans")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping
    public ResponseEntity<List<PlanDTO>> findAll() {
        List<PlanDTO> listPlan = planService.findAll();
        return ResponseEntity.ok().body(listPlan);
    }
}