package com.appgate.prueba.tasks;

import com.appgate.prueba.interactions.Save;
import com.appgate.prueba.models.RequestData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.appgate.prueba.utils.constants.General.TIME_ZONE_API;
import static com.appgate.prueba.utils.constants.General.USER_API;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Request implements Task {

    RequestData requestData;

    public Request(RequestData requestData) {
        this.requestData = requestData;
    }

    public static RequestBuilder timeZoneInformation() {
        return new RequestBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(String.format(TIME_ZONE_API,requestData.getLatitude(),requestData.getLength(),USER_API))
                        .with(request -> request
                                .request().log().all()
                        ),
                Save.response()
        );

    }


}
