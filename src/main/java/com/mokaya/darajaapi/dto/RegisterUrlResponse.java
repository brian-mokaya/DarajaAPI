package com.mokaya.darajaapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterUrlResponse {

    @JsonProperty("requestId")
    private String requestId;
    
    @JsonProperty("conversationId")
    private String conversationId;

    @JsonProperty("responseDescription")
    private String responseDescription;

    @JsonProperty("OriginatorConversationID")
    private String originatorConversationId;
    
    @JsonProperty("errorCode")
    private String errorCode;
    
    @JsonProperty("errorMessage")
    private String errorMessage;
}
