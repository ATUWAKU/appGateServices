package com.appgate.prueba.exceptions;

public class TimeZoneQueryException extends AssertionError {

    private static final String MSG = "La información de zona horaria no es correcta";

    public TimeZoneQueryException() {
        super(MSG);
    }
}
