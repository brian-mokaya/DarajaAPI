package com.mokaya.darajaapi.constants;

import com.squareup.okhttp.MediaType;

import java.awt.*;

public class Constants {
    public static final String BASIC_AUTH_STRING = "Basic ";
    public static final String BEARER_AUTH_STRING = "Bearer ";
    public static final String AUTHORIZATION_HEADER_STRING = "Authorization";
    public static final String CACHE_CONTROL_HEADER_VALUE = "no-cache";
    public static final String CACHE_CONTROL_HEADER = "Cache-Control";
    public static final String USER_AGENT_HEADER = "User-Agent";
    public static final String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36";
    public static final String ACCEPT_HEADER = "Accept";
    public static final String ACCEPT_VALUE = "application/json";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    public static final String TRANSACTION_STATUS_QUERY_COMMAND = "TransactionStatusQuery";
    public static final String TRANSACTION_STATUS_VALUE = "Transaction Status";
    public static final String MSISDN_IDENTIFIER = "1";
    public static final String TILL_NUMBER_IDENTIFIER = "2";
    public static final String SHORT_CODE_IDENTIFIER = "4";
    public static final String ACCOUNT_BALANCE_COMMAND = "AccountBalance";

}
