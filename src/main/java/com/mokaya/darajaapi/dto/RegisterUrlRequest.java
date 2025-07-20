package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

//@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUrlRequest {
    @JsonProperty("ShortCode")
    private String shortCode;

    @JsonProperty("ResponseType")
    private String responseType;

    @JsonProperty("ConfirmationURL")
    private String confirmationUrl;

    @JsonProperty("ValidationURL")
    private String validationUrl;
}
