package com.fiap.placeforpet.service.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String erronull){
        super(erronull);

    }

}
