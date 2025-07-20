package com.mokaya.darajaapi.controller;


import com.mokaya.darajaapi.dto.*;
import com.mokaya.darajaapi.service.DarajaApiImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mobile-money")
public class MpesaController {

    private final DarajaApiImpl darajaApi;
    private final AcknowledgeResponse acknowledgeResponse;

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

    @PostMapping(path = "/validate-transaction", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> validateTransaction(@RequestBody TransactionResults transactionResults) {
        System.out.println("✅ Transaction received: " + transactionResults);
        return ResponseEntity.ok(acknowledgeResponse);
    }

    @PostMapping(path = "/simulate-transaction", produces = "application/json")
    public ResponseEntity<SimulateC2BResponse> simulateC2BTransaction(@RequestBody SimulateC2BRequest simulateC2BRequest) {
        System.out.println("Simulating C2B transaction: " + simulateC2BRequest);
        return ResponseEntity.ok(darajaApi.simulateC2BTransaction(simulateC2BRequest));
    }



}
