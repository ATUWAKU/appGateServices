package com.appgate.prueba.exceptions;

public class TimeZoneQueryException extends AssertionError {

    public static final String MESSAGE = "La informacion que entrego el S.W de zona horaria no corresponde al que usted tiene de muestra";

    public TimeZoneQueryException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
