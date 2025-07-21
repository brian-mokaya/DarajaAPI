package com.mokaya.darajaapi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mokaya.darajaapi.dto.*;
import com.mokaya.darajaapi.service.DarajaApiImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/validation", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE }, produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> validateTransaction(@RequestBody String rawBody) {
        System.out.println("✅ Raw transaction received: " + rawBody);

        try {
            TransactionResults transaction = objectMapper.readValue(rawBody, TransactionResults.class);
            System.out.println("✅ Parsed Transaction: " + transaction);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(acknowledgeResponse);
    }


    @PostMapping(path = "/simulate-transaction", produces = "application/json")
    public ResponseEntity<SimulateC2BResponse> simulateC2BTransaction(@RequestBody SimulateC2BRequest simulateC2BRequest) {
        System.out.println("Simulating C2B transaction: " + simulateC2BRequest);
        return ResponseEntity.ok(darajaApi.simulateC2BTransaction(simulateC2BRequest));
    }



}
