package com.mokaya.darajaapi.service;

import com.mokaya.darajaapi.dto.AccessTokenResponse;
import com.mokaya.darajaapi.dto.RegisterUrlResponse;
import com.mokaya.darajaapi.dto.SimulateC2BRequest;
import com.mokaya.darajaapi.dto.SimulateC2BResponse;

public interface DarajaApi {

    /**
     * * Retrieves an access token from the Daraja API.
     *
     * @return AccessTokenResponse containing the access token and its expiration time.
    */
    AccessTokenResponse getAccessToken();


    /**
     * Registers a URL for receiving notifications from the Daraja API.
     *
     * @return RegisterUrlResponse containing the result of the registration.
     */
    RegisterUrlResponse registerUrl();


    /**
     * Simulates a C2B transaction.
     *
     * @return SimulateC2BResponse containing the result of the simulation.
     */

    SimulateC2BResponse simulateC2BTransaction(SimulateC2BRequest simulateC2BRequest);


}
