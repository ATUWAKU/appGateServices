package com.appgate.prueba.interactions;

import com.appgate.prueba.models.ResponseData;
import com.appgate.prueba.models.ResponseError;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static com.appgate.prueba.utils.constants.General.RESPONSE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Save implements Interaction {



    public static Performable response() {
        return instrumented(Save.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        ResponseData response;

        if(SerenityRest.lastResponse().jsonPath().get("status") != null){
            response = new ResponseData();
            response.setResponseError(SerenityRest.lastResponse().jsonPath().getObject("status", ResponseError.class));
        }
        else {
            response = SerenityRest.lastResponse().jsonPath().getObject("", ResponseData.class);
        }
        response.setStatusCode(Integer.toString(SerenityRest.lastResponse().getStatusCode()));
        
        actor.remember(RESPONSE, response);



    }
}
