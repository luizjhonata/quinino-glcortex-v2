package com.luizjhonata.quininoglcortex.controlleradvice;

public class PlanNotFoundException extends RuntimeException{

    public PlanNotFoundException() {
        super("Plano não disponível pela Q.uinino Telefonia");
    }
}
