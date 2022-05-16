package com.appgate.prueba.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ResponseData {
    @SerializedName("sunrise")
    @Expose
    public String sunrise;
    @SerializedName("lng")
    @Expose
    public String lng;
    @SerializedName("countryCode")
    @Expose
    public String countryCode;
    @SerializedName("gmtOffset")
    @Expose
    public String gmtOffset;
    @SerializedName("rawOffset")
    @Expose
    public String rawOffset;
    @SerializedName("sunset")
    @Expose
    public String sunset;
    @SerializedName("timezoneId")
    @Expose
    public String timezoneId;
    @SerializedName("dstOffset")
    @Expose
    public String dstOffset;
    @SerializedName("countryName")
    @Expose
    public String countryName;
    @SerializedName("time")
    @Expose
    public String time;
    @SerializedName("lat")
    @Expose
    public String lat;
    public String statusCode;
    public ResponseError responseError;

    public ResponseData() {
        this.sunrise = "";
        this.lng = "";
        this.countryCode = "";
        this.gmtOffset = "";
        this.rawOffset = "";
        this.sunset = "";
        this.timezoneId = "";
        this.dstOffset = "";
        this.countryName = "";
        this.time = "";
        this.lat = "";
        this.statusCode = "";
        this.responseError = new ResponseError();
    }

    public ResponseError getResponseError() {
        return responseError == null ? new ResponseError() : responseError;
    }




}
