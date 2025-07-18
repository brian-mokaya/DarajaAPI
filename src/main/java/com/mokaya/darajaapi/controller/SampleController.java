package com.mokaya.darajaapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping(produces = "application/json")
    public String getSample() {
        return "This is a sample response from the Daraja API";
    }

}
