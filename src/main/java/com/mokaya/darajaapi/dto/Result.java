package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result{

	@JsonProperty("ConversationID")
	private String conversationID;

	@JsonProperty("ReferenceData")
	private ReferenceData referenceData;

	@JsonProperty("OriginatorConversationID")
	private String originatorConversationID;

	@JsonProperty("ResultDesc")
	private String resultDesc;

	@JsonProperty("ResultType")
	private int resultType;

	@JsonProperty("ResultCode")
	private int resultCode;

	@JsonProperty("TransactionID")
	private String transactionID;
}