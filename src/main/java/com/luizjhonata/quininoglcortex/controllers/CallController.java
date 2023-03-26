package com.luizjhonata.quininoglcortex.controllers;

import com.luizjhonata.quininoglcortex.models.Call;
import com.luizjhonata.quininoglcortex.services.CallService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "costcalls")
public class CallController {

    private final CallService callService;

    public CallController(CallService callService) {
        this.callService = callService;
    }

    @Operation(summary = "Method to calculate costs of a call")
    @CrossOrigin(origins = "https://luxury-peony-57e6bc.netlify.app/")
//    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping
    public ResponseEntity<Call> callResponseEntity (String origin, String destiny, Double time, Long planId) throws RuntimeException {
        Call call = callService.calculateCallCost(origin, destiny, time, planId);
        return ResponseEntity.ok(call);
    }
}