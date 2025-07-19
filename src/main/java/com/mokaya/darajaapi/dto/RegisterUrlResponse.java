package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUrlResponse {
    @JsonProperty("conversationId")
    private String conversationId;

    @JsonProperty("responseDescription")
    private String responseDescription;

    @JsonProperty("OriginatorConversationID")
    private String originatorConversationId;
}
