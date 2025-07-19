package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterUrlRequest {
    @JsonProperty("shortCode")
    private String shortCode;

    @JsonProperty("responseType")
    private String responseType;

    @JsonProperty("confirmationURL")
    private String confirmationUrl;

    @JsonProperty("validationURL")
    private String validationUrl;
}
