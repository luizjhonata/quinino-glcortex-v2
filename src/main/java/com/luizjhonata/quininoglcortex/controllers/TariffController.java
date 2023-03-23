package com.luizjhonata.quininoglcortex.controllers;

import com.luizjhonata.quininoglcortex.services.TariffService;
import dto.TariffDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "tariffs")
public class TariffController {

    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @PostMapping
    public ResponseEntity<TariffDTO> insertTariff(@RequestBody TariffDTO newTariff) {
        tariffService.insertTariff(newTariff);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTariff);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TariffDTO> updateTariff(@PathVariable Long id, @RequestBody TariffDTO tariff) {
        tariffService.updateTariff(tariff);
        return ResponseEntity.ok(tariff);
    }

    @DeleteMapping("/{id}")
    public void deleteTariffById(@PathVariable Long id) {
        tariffService.deleteTariffById(id);
    }
}