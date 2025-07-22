package com.mokaya.darajaapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterUrlResponse {

    @JsonProperty("requestId")
    private String requestId;
    
    @JsonProperty("conversationId")
    private String conversationId;

    @JsonProperty("ResponseDescription")
    private String responseDescription;

    @JsonProperty("OriginatorCoversationID")
    private String originatorCoversationId;

    @JsonProperty("ResponseCode")
    private String responseCode;

    @JsonProperty("errorCode")
    private String errorCode;
    
    @JsonProperty("errorMessage")
    private String errorMessage;
}
