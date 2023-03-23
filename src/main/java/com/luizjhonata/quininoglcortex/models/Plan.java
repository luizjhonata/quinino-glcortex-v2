package com.luizjhonata.quininoglcortex.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be null")
    @NotBlank(message = "Plan cannot be blank")
    private String name;

    @Min(value = 0, message = "Minutes cannot be negative")
    @NotNull(message = "Please enter a minute amount")
    private Double freeMinutes;

    @Min(value = 0, message = "Additional Tariff cannot be less than 0")
    @NotNull
    private Double additionalTariff;

    public Plan() {
    }

    public Plan(Long id, String name, Double freeMinutes, Double additionalTariff) {
        this.id = id;
        this.name = name;
        this.freeMinutes = freeMinutes;
        this.additionalTariff = additionalTariff;
    }

    public Plan(Plan newPlan) {

    }

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

    public Double getFreeMinutes() {
        return freeMinutes;
    }

    public void setFreeMinutes(Double freeMinutes) {
        this.freeMinutes = freeMinutes;
    }

    public Double getAdditionalTariff() {
        return additionalTariff;
    }

    public void setAdditionalTariff(Double additionalTariff) {
        this.additionalTariff = additionalTariff;
    }
}