package com.mokaya.darajaapi.service;

import com.mokaya.darajaapi.dto.AccessTokenResponse;
import com.mokaya.darajaapi.dto.RegisterUrlResponse;

public interface DarajaApi {

/**
 * Retrieves an access token from the Daraja API.
 *
 * @return AccessTokenResponse containing the access token and its expiration time.
 */
AccessTokenResponse getAccessToken();

RegisterUrlResponse registerUrl();
}
