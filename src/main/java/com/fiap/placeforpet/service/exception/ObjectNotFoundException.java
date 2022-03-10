package com.fiap.placeforpet.service.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -6044128565353541163L;

    public ObjectNotFoundException(String message ){
        super(message);
    }
}
