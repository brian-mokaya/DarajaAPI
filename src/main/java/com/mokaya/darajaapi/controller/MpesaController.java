package com.mokaya.darajaapi.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mokaya.darajaapi.dto.*;
import com.mokaya.darajaapi.service.DarajaApiImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("mobile-money")
public class MpesaController {

    private final DarajaApiImpl darajaApi;
    private final AcknowledgeResponse acknowledgeResponse;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public MpesaController(DarajaApiImpl darajaApi, AcknowledgeResponse acknowledgeResponse) {
        this.darajaApi = darajaApi;
        this.acknowledgeResponse = acknowledgeResponse;

    }

    @GetMapping(path = "/token" , produces = "application/json")
    public ResponseEntity<AccessTokenResponse> getAccessToken() {
        return ResponseEntity.ok(darajaApi.getAccessToken());
    }

    @PostMapping(path = "/register-url", produces = "application/json")
    public ResponseEntity<RegisterUrlResponse> registerUrl() {
        return ResponseEntity.ok(darajaApi.registerUrl());
    }


    @PostMapping(path = "/validation", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> mpesaValidation(@RequestBody MpesaValidationResponse mpesaValidationResponse) {
        return ResponseEntity.ok(acknowledgeResponse);
    }



    @PostMapping(path = "/simulate-transaction", produces = "application/json")
    public ResponseEntity<SimulateC2BResponse> simulateC2BTransaction(@RequestBody SimulateC2BRequest simulateC2BRequest) {
        System.out.println("Simulating C2B transaction: " + simulateC2BRequest);
        return ResponseEntity.ok(darajaApi.simulateC2BTransaction(simulateC2BRequest));
    }


    // === B2C Transaction Region ====

    @PostMapping(path = "/transaction-result", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> b2cTransactionAsyncResults(@RequestBody B2CTransactionAsyncResponse b2CTransactionAsyncResponse) {
        System.out.println("B2C Transaction Async Results: " + b2CTransactionAsyncResponse);

        log.info("============ B2C Transaction Response =============");
        try {
            log.info(objectMapper.writeValueAsString(b2CTransactionAsyncResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(acknowledgeResponse);

    }


    @PostMapping(path = "/queue-timeout", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> queueTimeout(@RequestBody Object object) {
        return ResponseEntity.ok(acknowledgeResponse);
    }

    @PostMapping(path = "/b2c-transaction", produces = "application/json")
    public ResponseEntity<CommonTransactionSyncResponse> performB2CTransaction(@RequestBody InternalB2CTransactionRequest internalB2CTransactionRequest) {
        return ResponseEntity.ok(darajaApi.performB2CTransaction(internalB2CTransactionRequest));
    }

    @PostMapping(path = "/transaction-status", produces = "application/json")
    public ResponseEntity<TransactionStatusSyncResponse> getTransactionStatus(@RequestBody InternalTransactionStatusRequest internalTransactionStatusRequest) {
        return ResponseEntity.ok(darajaApi.getTransactionStatus(internalTransactionStatusRequest));
    }

    @GetMapping(path = "/check-balance", produces = "application/json")
    public ResponseEntity<CommonTransactionSyncResponse> checkBalance() {
        return ResponseEntity.ok(darajaApi.checkAccountBalance());
    }


}
