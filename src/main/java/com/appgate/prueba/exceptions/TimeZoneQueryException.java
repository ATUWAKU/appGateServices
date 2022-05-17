package com.appgate.prueba.exceptions;

public class TimeZoneQueryException extends AssertionError {

    private static final String MESSAGE = "La información que entregó el SW de zona horaria no corresponde al que usted tiene de muestra";

    public TimeZoneQueryException() {
        super(MESSAGE);
    }
}
