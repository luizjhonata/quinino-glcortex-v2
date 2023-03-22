package com.luizjhonata.quininoglcortex.controlleradvice;

import com.luizjhonata.quininoglcortex.services.CallService;

public class TariffNotFoundException extends RuntimeException {

    public TariffNotFoundException(String msg) {
        super(msg);
    }

}
