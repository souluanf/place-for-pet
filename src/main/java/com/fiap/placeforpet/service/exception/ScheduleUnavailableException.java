package com.fiap.placeforpet.service.exception;

import org.springframework.http.HttpStatus;

public class ScheduleUnavailableException extends RuntimeException {
    private static final long serialVersionUID = -6044128565353541163L;

    public ScheduleUnavailableException(HttpStatus httpStatus, String message ){
        super(message);
    }
}
