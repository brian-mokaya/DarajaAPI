package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StkPushSyncResponse{


	@JsonProperty("MerchantRequestID")
	private String merchantRequestID;

	@JsonProperty("CheckoutRequestID")
	private String checkoutRequestID;

	@JsonProperty("ResponseCode")
	private String responseCode;

	@JsonProperty("CustomerMessage")
	private String customerMessage;

	@JsonProperty("ResponseDescription")
	private String responseDescription;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("status")
	private String status;

	@JsonProperty("error")
	private String error;

	@JsonProperty("trace")
	private String trace;

	@JsonProperty("message")
	private String message;

	@JsonProperty("path")
	private String path;

}