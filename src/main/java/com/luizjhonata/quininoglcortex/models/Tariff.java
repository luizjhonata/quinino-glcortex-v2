package com.luizjhonata.quininoglcortex.models;

import com.luizjhonata.quininoglcortex.enums.Ddd;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Ddd origin;

    @Enumerated(EnumType.STRING)
    private Ddd destiny;

    private Double pricePerMinute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ddd getOrigin() {
        return origin;
    }

    public void setOrigin(Ddd origin) {
        this.origin = origin;
    }

    public Ddd getDestiny() {
        return destiny;
    }

    public void setDestiny(Ddd destiny) {
        this.destiny = destiny;
    }

    public Double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(Double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public Tariff() {
    }

    public Tariff(Long id, Ddd origin, Ddd destiny, Double pricePerMinute) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.pricePerMinute = pricePerMinute;
    }
}
