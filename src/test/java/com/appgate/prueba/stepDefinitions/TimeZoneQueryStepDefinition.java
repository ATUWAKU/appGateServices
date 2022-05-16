package com.appgate.prueba.stepDefinitions;

import com.appgate.prueba.models.RequestData;
import com.appgate.prueba.models.ResponseData;
import com.appgate.prueba.questions.Response;
import com.appgate.prueba.tasks.Request;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static com.appgate.prueba.utils.constants.General.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TimeZoneQueryStepDefinition {

    @Before
    public void setup(){

        OnStage.setTheStage(OnlineCast.whereEveryoneCan(
                CallAnApi.at(BASE_URL_API)));
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @DataTableType
    public RequestData convert(Map<String, String> object){
        RequestData obj = new RequestData();

        obj.setLatitude(object.get("Latitude"));
        obj.setLength(object.get("Length"));
        return obj;
    }

    @DataTableType
    public ResponseData transform(Map<String, String> object){
        ResponseData obj = new ResponseData();

        obj.setSunrise(object.get("Sunrise") == null ? "" : object.get("Sunrise"));
        obj.setLng(object.get("Lng") == null ? "" : object.get("Lng"));
        obj.setCountryCode(object.get("Countrycode") == null ? "" : object.get("Countrycode"));
        obj.setGmtOffset(object.get("Gmtoffset") == null ? "" : object.get("Gmtoffset"));
        obj.setRawOffset(object.get("Rawoffset") == null ? "" : object.get("Rawoffset"));
        obj.setSunset(object.get("Sunset") == null ? "" : object.get("Sunset"));
        obj.setTimezoneId(object.get("Timezoneid") == null ? "" : object.get("Timezoneid"));
        obj.setDstOffset(object.get("Dstoffset") == null ? "" : object.get("Dstoffset"));
        obj.setCountryName(object.get("Countryname") == null ? "" : object.get("Countryname"));
        obj.setTime(object.get("Time") == null ? "" : object.get("Time"));
        obj.setLat(object.get("Lat") == null ? "" : object.get("Lat"));
        obj.getResponseError().setMessage(object.get("Message") == null ? "" : object.get("Message"));
        obj.getResponseError().setValue(object.get("Value") == null ? "" : object.get("Value"));
        obj.setStatusCode(object.get("StatusCode") == null ? "" : object.get("StatusCode"));
        return obj;
    }

    @When("Consult the time zone information with")
    public void consultTheTimeZoneInformationWith(RequestData requestData) {
        theActorCalled(FRONTEND).attemptsTo(
                Request.timeZoneInformation().whit(requestData)
        );
    }
    @Then("The service displays")
    public void theServiceDisplays(ResponseData responseData) {
        theActorInTheSpotlight().should(seeThat(
                Response.isequals(responseData), x -> x.equals(true)
        ));

    }
}
