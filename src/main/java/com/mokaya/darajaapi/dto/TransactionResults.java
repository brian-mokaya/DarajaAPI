package com.mokaya.darajaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionResults {

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("CommandID")
    private String commandID;

    @JsonProperty("TransID")
    private String transID;

    @JsonProperty("TransTime")
    private String transTime;

    @JsonProperty("Amount")
    private String transAmount;

    @JsonProperty("ShortCode")
    private String businessShortCode;

    @JsonProperty("BillRefNumber")
    private String billRefNumber;

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;

    @JsonProperty("OrgAccountBalance")
    private String orgAccountBalance;

    @JsonProperty("ThirdPartyTransID")
    private String thirdPartyTransID;

    @JsonProperty("Msisdn")
    private String msisdn;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("MiddleName")
    private String middleName;

    @JsonProperty("LastName")
    private String lastName;

}
