package com.luizjhonata.quininoglcortex.repositories;

import com.luizjhonata.quininoglcortex.models.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {
    Optional<Tariff> findByOriginAndDestiny(String origin, String destiny);
}
