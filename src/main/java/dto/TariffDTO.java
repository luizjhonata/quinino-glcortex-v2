package dto;

import com.luizjhonata.quininoglcortex.enums.Ddd;
import com.luizjhonata.quininoglcortex.models.Tariff;

public class TariffDTO {

    private Long id;

    private String origin;

    private String destiny;

    private Double pricePerMinute;

    public TariffDTO() {
    }

    public TariffDTO(Long id, String origin, String destiny, Double pricePerMinute) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.pricePerMinute = pricePerMinute;
    }

    public TariffDTO(Tariff tariff) {
        id = tariff.getId();
        origin = tariff.getOrigin();
        destiny = tariff.getDestiny();
        pricePerMinute = tariff.getPricePerMinute();
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
