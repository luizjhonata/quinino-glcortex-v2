package com.luizjhonata.quininoglcortex.models;

public class Call {

    private Long id;

    private String origin;

    private String destiny;

    private Double time;

    private Plan plan;

    private Double costWithPlan;

    private Double costWithoutPlan;

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

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Double getCostWithPlan() {
        return costWithPlan;
    }

    public void setCostWithPlan(Double costWithPlan) {
        this.costWithPlan = costWithPlan;
    }

    public Double getCostWithoutPlan() {
        return costWithoutPlan;
    }

    public void setCostWithoutPlan(Double costWithoutPlan) {
        this.costWithoutPlan = costWithoutPlan;
    }

    public Call() {
    }

    public Call(Long id, String origin, String destiny, Double time, Plan plan, Double costWithPlan, Double costWithoutPlan) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.time = time;
        this.plan = plan;
        this.costWithPlan = costWithPlan;
        this.costWithoutPlan = costWithoutPlan;
    }
}
