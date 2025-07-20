package com.mokaya.darajaapi.service;

import static com.mokaya.darajaapi.constants.Constants.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mokaya.darajaapi.config.MpesaConfiguration;
import com.mokaya.darajaapi.dto.*;
import com.mokaya.darajaapi.utils.HelperUtility;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@Slf4j
public class DarajaApiImpl implements DarajaApi{

    private final MpesaConfiguration mpesaConfiguration;
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

public DarajaApiImpl(MpesaConfiguration mpesaConfiguration, OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        this.mpesaConfiguration = mpesaConfiguration;
        this.okHttpClient = okHttpClient;
        this.objectMapper = objectMapper;
    }

    /*
    *Get the base64 encoded credentials for the M-Pesa API.
    * This method constructs a request to the M-Pesa OAuth endpoint
    * to retrieve an access token using the consumer key and secret.
     */
    @Override
    public AccessTokenResponse getAccessToken() {
        String encodedCredentials = HelperUtility.toBase64(String.format("%s:%s",
                mpesaConfiguration.getConsumerKey(),
                mpesaConfiguration.getConsumerSecret()));

        Request request = new Request.Builder()
                .url(String.format(mpesaConfiguration.getOauthEndpoint(), mpesaConfiguration.getGrantType()))
                .get()
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s%s", BASIC_AUTH_STRING, encodedCredentials))
                .addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
                .addHeader(USER_AGENT_HEADER, USER_AGENT_VALUE)
                .addHeader(ACCEPT_HEADER, ACCEPT_VALUE)
                .addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            String responseBody = response.body().string();

            if (!response.isSuccessful()) {
                log.error("Error response from API: {}", responseBody);

                // Check if the response contains Incapsula WAF block indicators
                if (responseBody.contains("Incapsula") || responseBody.contains("_Incapsula_Resource")) {
                    log.error("Request blocked by Incapsula WAF. Please check your request headers and try again.");
                    throw new RuntimeException("Failed to fetch access token - Request blocked by security measures. Please try again later.");
                }

                throw new RuntimeException("Failed to fetch access token - API returned error: " + responseBody);
            }

            return objectMapper.readValue(responseBody, AccessTokenResponse.class);
        } catch (Exception e) {
            // Check if the exception message contains Incapsula indicators
            if (e.getMessage() != null && (e.getMessage().contains("Incapsula") || e.getMessage().contains("_Incapsula_Resource"))) {
                log.error("Request likely blocked by Incapsula WAF: {}", e.getMessage());
                throw new RuntimeException("Failed to fetch access token - Request blocked by security measures. Please try again later.", e);
            }
            
            log.error("Error while fetching access token: {}", e.getMessage());
            throw new RuntimeException("Failed to fetch access token", e);
        }
    }

    @Override
    public RegisterUrlResponse registerUrl() {
        AccessTokenResponse accessTokenResponse = getAccessToken();

        RegisterUrlRequest registerUrlRequest= new RegisterUrlRequest();
        registerUrlRequest.setConfirmationUrl(mpesaConfiguration.getConfirmationUrl());
        registerUrlRequest.setShortCode(mpesaConfiguration.getShortCode());
        registerUrlRequest.setValidationUrl(mpesaConfiguration.getValidationUrl());
        registerUrlRequest.setResponseType(mpesaConfiguration.getResponseType());

        RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE,HelperUtility.toJson(registerUrlRequest));

        Request request = new Request.Builder()
                .url(mpesaConfiguration.getRegisterUrlEndpoint())
                .post(requestBody)
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s%s", BEARER_AUTH_STRING, accessTokenResponse.getAccessToken()))
                .addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
                .addHeader(USER_AGENT_HEADER, USER_AGENT_VALUE)
                .addHeader(ACCEPT_HEADER, ACCEPT_VALUE)
                .addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            String responseBody = response.body().string();
            return objectMapper.readValue(responseBody, RegisterUrlResponse.class);
        } catch (IOException e) {
            log.error("Error while registering URL: {}", e.getMessage());
            throw new RuntimeException(e);
        }


    }

    @Override
    public SimulateC2BResponse simulateC2BTransaction(SimulateC2BRequest simulateC2BRequest) {
        AccessTokenResponse accessTokenResponse = getAccessToken();

        RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, HelperUtility.toJson(simulateC2BRequest));

        Request request = new Request.Builder()
                .url(mpesaConfiguration.getSimulateTransactionEndpoint())
                .post(requestBody)
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s%s", BEARER_AUTH_STRING, accessTokenResponse.getAccessToken()))
                .addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
                .addHeader(USER_AGENT_HEADER, USER_AGENT_VALUE)
                .addHeader(ACCEPT_HEADER, ACCEPT_VALUE)
                .addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            String responseBody = response.body().string();
            return objectMapper.readValue(responseBody, SimulateC2BResponse.class);
        } catch (IOException e) {
            log.error("Error while simulating C2B transaction: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}