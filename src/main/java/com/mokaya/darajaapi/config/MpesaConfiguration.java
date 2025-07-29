package com.mokaya.darajaapi.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mpesa")
public class MpesaConfiguration {
    private String consumerKey;
    private String consumerSecret;
    private String oauthEndpoint;
    private String grantType;
    private String shortCode;
    private String responseType;
    private String validationUrl;
    private String confirmationUrl;
    private String registerUrlEndpoint;
    private String simulateTransactionEndpoint;
    private String b2cTransactionEndpoint;
    private String b2cResultUrl;
    private String b2cQueueTimeoutUrl;
    private String b2cInitiatorName;
    private String b2cInitiatorPassword;
    private String transactionResultUrl;
    private  String CheckAccountBalanceUrl;
    private String stkCallBackURL;
    private String stkPassKey;
    private String stkPushShortCode;
    private String stkPushRequestUrl;

    @Override
    public String toString() {
        return "MpesaConfiguration{" +
                "consumerKey='" + consumerKey + '\'' +
                ", consumerSecret='" + consumerSecret + '\'' +
                ", oauthUrl='" + oauthEndpoint + '\'' +
                ", grantType='" + grantType + '\'' +
                ", shortCode='" + shortCode + '\'' +
                '}';
    }
}
