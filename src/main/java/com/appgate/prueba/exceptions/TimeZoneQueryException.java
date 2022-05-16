package com.appgate.prueba.exceptions;

public class TimeZoneQueryException extends AssertionError {

    private static final String MSG = "La información de zona horaria se dañó";

    public TimeZoneQueryException(String msg) {
        super(MSG);
    }
}
