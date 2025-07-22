package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionStatusSyncResponse{

	@JsonProperty("requestId")
	private String requestId;

	@JsonProperty("ConversationID")
	private String conversationID;

    @JsonProperty("errorCode")
	private String errorCode;

	@JsonProperty("errorMessage")
	private String errorMessage;

	@JsonProperty("ResponseCode")
	private String responseCode;

	@JsonProperty("OriginatorConversationID")
	private String originatorConversationID;

	@JsonProperty("ResponseDescription")
	private String responseDescription;

}