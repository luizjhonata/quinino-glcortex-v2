package com.luizjhonata.quininoglcortex.controllers;

import com.luizjhonata.quininoglcortex.enums.Ddd;
import com.luizjhonata.quininoglcortex.models.Call;
import com.luizjhonata.quininoglcortex.services.CallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "calls")
public class CallController {

    private final CallService callService;

    public CallController(CallService callService) {
        this.callService = callService;
    }


    @GetMapping
    public ResponseEntity<Call> callResponseEntity (Ddd origin, Ddd destiny, Double time, Long planId) throws Exception {
        Call call = callService.calculateCallCost(origin, destiny, time, planId);
        return ResponseEntity.ok(call);
    }

}
