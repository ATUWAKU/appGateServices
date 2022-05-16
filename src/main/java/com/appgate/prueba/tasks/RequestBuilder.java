package com.appgate.prueba.tasks;

import com.appgate.prueba.models.RequestData;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RequestBuilder {
    public Performable whit(RequestData requestData) {
        return instrumented(Request.class, requestData);
    }
}
