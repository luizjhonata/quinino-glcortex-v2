package com.luizjhonata.quininoglcortex.services;

import com.luizjhonata.quininoglcortex.controlleradvice.TariffNotFoundException;
import com.luizjhonata.quininoglcortex.dto.PlanDTO;
import com.luizjhonata.quininoglcortex.models.Plan;
import com.luizjhonata.quininoglcortex.models.Tariff;
import com.luizjhonata.quininoglcortex.repositories.TariffRepository;
import com.luizjhonata.quininoglcortex.dto.TariffDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TariffService {

    private final TariffRepository tariffRepository;

    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public TariffDTO insertTariff(@RequestBody TariffDTO tariffDTO) {
        Tariff newTariff = new Tariff (null, tariffDTO.getOrigin(),
                tariffDTO.getDestiny(), tariffDTO.getPricePerMinute());
        tariffRepository.save(newTariff);
        return new TariffDTO(newTariff);
    }

    @Transactional
    public TariffDTO updateTariff(TariffDTO tariff) {
        if(tariffRepository.existsById(tariff.getId())) {
            Tariff updateTariff = tariffRepository.getReferenceById(tariff.getId());
            updateTariff.setId(tariff.getId());
            if (tariff.getOrigin() == null || tariff.getOrigin() == "" ) {
                tariff.setOrigin(updateTariff.getOrigin());
            }
            if (tariff.getDestiny() == null || tariff.getDestiny() == "") {
                tariff.setDestiny(updateTariff.getDestiny());
            }
            if(tariff.getPricePerMinute() == null || tariff.getPricePerMinute() == 0) {
                tariff.setPricePerMinute(updateTariff.getPricePerMinute());
            }
            updateTariff.setDestiny(tariff.getDestiny());
            updateTariff.setOrigin(tariff.getOrigin());
            updateTariff.setPricePerMinute(tariff.getPricePerMinute());
            tariffRepository.save(updateTariff);
        }
        return tariff;
    }

    @Transactional
    public void deleteTariffById(Long id) throws RuntimeException{
        Tariff tariff = tariffRepository.findById(id).orElseThrow(() -> new TariffNotFoundException("Tarifa não Encontrada"));
        tariffRepository.deleteById(id);
    }

    public List<TariffDTO> findAll() {
        List<Tariff> listTariff = tariffRepository.findAll();
        return listTariff.stream().map(x -> new TariffDTO(x)).collect(Collectors.toList());
    }
}