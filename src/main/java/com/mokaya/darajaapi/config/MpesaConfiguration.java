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

    @Override
    public String toString() {
        return "MpesaConfiguration{" +
                "consumerKey='" + consumerKey + '\'' +
                ", consumerSecret='" + consumerSecret + '\'' +
                ", oauthUrl='" + oauthEndpoint + '\'' +
                ", grantType='" + grantType + '\'' +
                '}';
    }
}
