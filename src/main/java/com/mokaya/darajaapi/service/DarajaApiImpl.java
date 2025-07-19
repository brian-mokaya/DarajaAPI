package com.mokaya.darajaapi.service;

import static com.mokaya.darajaapi.constants.Constants.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mokaya.darajaapi.config.MpesaConfiguration;
import com.mokaya.darajaapi.dto.AccessTokenResponse;
import com.mokaya.darajaapi.utils.HelperUtility;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


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
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BASIC_AUTH_STRING, encodedCredentials))
                .addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            String responseBody = response.body().string();


            return objectMapper.readValue(responseBody, AccessTokenResponse.class);
        } catch (Exception e) {
            log.error("Error while fetching access token: {}", e.getMessage());
            throw new RuntimeException("Failed to fetch access token", e);

        }
    }
}