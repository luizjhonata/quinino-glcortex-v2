package com.luizjhonata.quininoglcortex.services;

import com.luizjhonata.quininoglcortex.models.Tariff;
import com.luizjhonata.quininoglcortex.repositories.TariffRepository;
import dto.TariffDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    public TariffDTO updateTariff(@PathVariable TariffDTO tariff) {
        if(tariffRepository.existsById(tariff.getId())) {
            Tariff updateTariff = tariffRepository.getReferenceById(tariff.getId());
            updateTariff.setId(tariff.getId());
            updateTariff.setDestiny(tariff.getDestiny());
            updateTariff.setOrigin(tariff.getOrigin());
            updateTariff.setPricePerMinute(tariff.getPricePerMinute());
            tariffRepository.save(updateTariff);
        }
        return tariff;
    }
}

