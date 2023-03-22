package com.luizjhonata.quininoglcortex.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;

    private String destiny;

    private Double pricePerMinute;

    public Tariff() {
    }

    public Tariff(Long id, String origin, String destiny, Double pricePerMinute) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.pricePerMinute = pricePerMinute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public Double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(Double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

}
