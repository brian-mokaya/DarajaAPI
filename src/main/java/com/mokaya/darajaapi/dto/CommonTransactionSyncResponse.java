package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CommonTransactionSyncResponse {

	@JsonProperty("requestId")
	private String requestId;

	@JsonProperty("ConversationID")
	private String conversationID;

	@JsonProperty("errorCode")
	public String errorCode;

	@JsonProperty("ResponseCode")
	private String responseCode;

	@JsonProperty("OriginatorConversationID")
	private String originatorConversationID;

	@JsonProperty("ResponseDescription")
	private String responseDescription;

	@JsonProperty("errorMessage")
	private String errorMessage;


}