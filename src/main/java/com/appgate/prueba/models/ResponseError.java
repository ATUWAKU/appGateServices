package com.appgate.prueba.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Setter;

@Data
public class ResponseError {

    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("value")
    @Expose
    public String value;

    public ResponseError() {
        this.message = "";
        this.value = "";
    }
}
