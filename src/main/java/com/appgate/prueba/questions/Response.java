package com.appgate.prueba.questions;

import com.appgate.prueba.models.ResponseData;
import com.appgate.prueba.utils.TypeData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.appgate.prueba.utils.ToolsTime.consultTime;
import static com.appgate.prueba.utils.TypeData.*;
import static com.appgate.prueba.utils.constants.General.RESPONSE;

public class Response implements Question<Boolean> {

    ResponseData expRespData;
    ResponseData obtRespData;

    public Response(ResponseData expRespData) {
        this.expRespData = expRespData;
    }

    private void modifyData(TypeData type){

        switch (type){
            case SUNRISE:
                if(LocalTime.now().isAfter(LocalTime.parse("12:00"))) {
                    expRespData.setSunrise(LocalDate.now().plusDays(1) + " " + obtRespData.getSunrise().split(" ")[1]);
                }
                break;
            case SUNSET:
                if(LocalTime.now().isAfter(LocalTime.parse("12:00"))) {
                    expRespData.setSunset(LocalDate.now().plusDays(1) + " " + obtRespData.getSunset().split(" ")[1]);
                }
                break;
            case TIME:
                expRespData.setTime(consultTime(expRespData.getTimezoneId()));
                obtRespData.setTime(consultTime(obtRespData.getTimezoneId()));
                break;
        }

    }

    public static Response isequals(ResponseData responseData) {
        return new Response(responseData);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        obtRespData = actor.recall(RESPONSE);
        if(obtRespData.getResponseError().getMessage().equals("")) {
            modifyData(SUNRISE);
            modifyData(SUNSET);
            modifyData(TIME);
        }

        boolean b;

        b = obtRespData.getSunrise().equals(expRespData.getSunrise()) &&
                obtRespData.getLng().equals(expRespData.getLng()) &&
                obtRespData.getCountryCode().equals(expRespData.getCountryCode()) &&
                obtRespData.getGmtOffset().equals(expRespData.getGmtOffset()) &&
                obtRespData.getRawOffset().equals(expRespData.getRawOffset()) &&
                obtRespData.getSunset().equals(expRespData.getSunset()) &&
                obtRespData.getTimezoneId().equals(expRespData.getTimezoneId()) &&
                obtRespData.getDstOffset().equals(expRespData.getDstOffset()) &&
                obtRespData.getCountryName().equals(expRespData.getCountryName()) &&
                obtRespData.getTime().equals(expRespData.getTime()) &&
                obtRespData.getLat().equals(expRespData.getLat());

        if(!b){
            System.out.println("MIERDA");
        }



        return
                obtRespData.getSunrise().equals(expRespData.getSunrise()) &&
                obtRespData.getLng().equals(expRespData.getLng()) &&
                obtRespData.getCountryCode().equals(expRespData.getCountryCode()) &&
                obtRespData.getGmtOffset().equals(expRespData.getGmtOffset()) &&
                obtRespData.getRawOffset().equals(expRespData.getRawOffset()) &&
                obtRespData.getSunset().equals(expRespData.getSunset()) &&
                obtRespData.getTimezoneId().equals(expRespData.getTimezoneId()) &&
                obtRespData.getDstOffset().equals(expRespData.getDstOffset()) &&
                obtRespData.getCountryName().equals(expRespData.getCountryName()) &&
                obtRespData.getTime().equals(expRespData.getTime()) &&
                obtRespData.getLat().equals(expRespData.getLat());
    }
}
