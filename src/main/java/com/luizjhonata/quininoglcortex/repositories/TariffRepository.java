package com.luizjhonata.quininoglcortex.repositories;

import com.luizjhonata.quininoglcortex.enums.Ddd;
import com.luizjhonata.quininoglcortex.models.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {
    Tariff findByOriginAndDestiny(Ddd origin, Ddd destiny);
}
