package com.luizjhonata.quininoglcortex.controllers;

import com.luizjhonata.quininoglcortex.enums.Ddd;
import com.luizjhonata.quininoglcortex.models.Call;
import com.luizjhonata.quininoglcortex.services.CallService;
import dto.PlanDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "calls")
public class CallController {

    private final CallService callService;

    public CallController(CallService callService) {
        this.callService = callService;
    }

    @GetMapping
    public ResponseEntity<Call> callResponseEntity (Ddd origin, Ddd destiny, Double time, Long planId) throws RuntimeException {
        Call call = callService.calculateCallCost(origin, destiny, time, planId);
        return ResponseEntity.ok(call);
    }

    @PostMapping
    public ResponseEntity<PlanDTO> insertPlan (@RequestBody PlanDTO newPlan) {
        callService.inserPlan(newPlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlan);
    }

}
