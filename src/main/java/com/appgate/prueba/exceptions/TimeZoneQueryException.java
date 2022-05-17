package com.appgate.prueba.exceptions;

public class TimeZoneQueryException extends AssertionError {

    private static final String MSG = "La información que entregó el S.W. de zona horaria no corresponde al que usted tiene de muestra";

    public TimeZoneQueryException() {
        super(MSG);
    }
}
