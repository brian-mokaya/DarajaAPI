package com.mokaya.darajaapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InternalTransactionStatusRequest {
    @JsonProperty("TransactionID")
    private String transactionID;
}
