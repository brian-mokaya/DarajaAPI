package com.mokaya.darajaapi.service;

import com.mokaya.darajaapi.dto.*;

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


    /**
     * Performs a B2C transaction.
     *
     * @param internalB2CTransactionRequest The request object containing details for the B2C transaction.
     * @return CommonTransactionSyncResponse containing the result of the B2C transaction.
     */
    CommonTransactionSyncResponse performB2CTransaction(InternalB2CTransactionRequest internalB2CTransactionRequest);


    /**
     * Retrieves the status of a transaction.
     *
     * @param internalTransactionStatusRequest The request object containing the transaction ID.
     * @return InternalTransactionStatusResponse containing the status of the transaction.
     */

    TransactionStatusSyncResponse getTransactionStatus(InternalTransactionStatusRequest internalTransactionStatusRequest);

    /**
     * Checks the account balance.
     *
     * @return CommonTransactionSyncResponse containing the account balance information.
     */
    CommonTransactionSyncResponse checkAccountBalance();

}