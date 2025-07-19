package com.mokaya.darajaapi.controller;


import com.mokaya.darajaapi.dto.AccessTokenResponse;
import com.mokaya.darajaapi.service.DarajaApiImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mpesa")
public class MpesaController {

    private final DarajaApiImpl darajaApi;

    public MpesaController(DarajaApiImpl darajaApi) {
        this.darajaApi = darajaApi;
    }

    @GetMapping(path = "/token")
    public ResponseEntity<AccessTokenResponse> getAccessToken() {
        return ResponseEntity.ok(darajaApi.getAccessToken());
    }

}
