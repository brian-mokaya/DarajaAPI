package com.mokaya.darajaapi.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mokaya.darajaapi.config.MpesaConfiguration;
import com.mokaya.darajaapi.dto.AccessTokenResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
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

    public AccessTokenResponse getAccessToken() {
   // implementation logic here
        return null;
    }
}