package com.luizjhonata.quininoglcortex.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Origin cannot be null")
    @NotEmpty(message = "Origin cannot be empty")
    @Size(max = 3, min = 3, message = "Please use the format 'XXX' ")
    private String origin;

    @NotNull(message = "Destiny cannot be null")
    @NotEmpty(message = "Destiny cannot be empty")
    @Size(max = 3, min = 3, message = "Please use the format 'XXX' ")
    private String destiny;

    @NotEmpty
    @NotNull
    @Min(value = 0, message = "Price cannot be less than 0")
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
