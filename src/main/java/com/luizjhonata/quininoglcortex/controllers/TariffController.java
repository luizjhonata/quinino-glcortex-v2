package com.luizjhonata.quininoglcortex.controllers;

import com.luizjhonata.quininoglcortex.dto.PlanDTO;
import com.luizjhonata.quininoglcortex.services.TariffService;
import com.luizjhonata.quininoglcortex.dto.TariffDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tariffs")
public class TariffController {

    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @Operation(summary = "Inserte a new Tariff")
//    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @CrossOrigin(origins = "https://quininov2.netlify.app/")
    @PostMapping
    public ResponseEntity<TariffDTO> insertTariff(@RequestBody TariffDTO newTariff) {
        tariffService.insertTariff(newTariff);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTariff);
    }

    @Operation(summary = "Update Tariff data")
//    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @CrossOrigin(origins = "https://quininov2.netlify.app/")
    @PutMapping
    public ResponseEntity<TariffDTO> updateTariff(@RequestBody TariffDTO tariff) {
        tariffService.updateTariff(tariff);
        return ResponseEntity.ok(tariff);
    }

    @Operation(summary = "Delete a Tariff")
//    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @CrossOrigin(origins = "https://quininov2.netlify.app/")
    @DeleteMapping("/{id}")
    public void deleteTariffById(@PathVariable Long id) {
        tariffService.deleteTariffById(id);
    }

    @Operation(summary = "Get a list off all tariffs")
//    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @CrossOrigin(origins = "https://quininov2.netlify.app/")
    @GetMapping
    public ResponseEntity<List<TariffDTO>> findAll() {
        List<TariffDTO> listTariff = tariffService.findAll();
        return ResponseEntity.ok().body(listTariff);
    }
}