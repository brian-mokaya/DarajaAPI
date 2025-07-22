package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MpesaValidationResponse{

    @JsonProperty("TransactionType")
    public String transactionType;

    @JsonProperty("TransID")
    public String transID;

    @JsonProperty("TransTime")
    public String transTime;

    @JsonProperty("TransAmount")
    public String transAmount;

    @JsonProperty("BusinessShortCode")
    public String businessShortCode;

    @JsonProperty("BillRefNumber")
    public String billRefNumber;

    @JsonProperty("InvoiceNumber")
    public String invoiceNumber;

    @JsonProperty("OrgAccountBalance")
    public String orgAccountBalance;

    @JsonProperty("ThirdPartyTransID")
    public String thirdPartyTransID;

    @JsonProperty("MSISDN")
    public String mSISDN;

    @JsonProperty("FirstName")
    public String firstName;

    @JsonProperty("MiddleName")
    public String middleName;

    @JsonProperty("LastName")
    public String lastName;
}