package com.luizjhonata.quininoglcortex.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String freeMinutes;

    private Double additionalTariff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFreeMinutes() {
        return freeMinutes;
    }

    public void setFreeMinutes(String freeMinutes) {
        this.freeMinutes = freeMinutes;
    }

    public Double getAdditionalTariff() {
        return additionalTariff;
    }

    public void setAdditionalTariff(Double additionalTariff) {
        this.additionalTariff = additionalTariff;
    }

    public Plan() {
    }

    public Plan(Long id, String name, String freeMinutes, Double additionalTariff) {
        this.id = id;
        this.name = name;
        this.freeMinutes = freeMinutes;
        this.additionalTariff = additionalTariff;
    }
}
