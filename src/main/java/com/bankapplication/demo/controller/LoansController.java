package com.bankapplication.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("myLoan")
    public String getLoanDetails(){
        return "Here are the loan details from DB";
    }
}
