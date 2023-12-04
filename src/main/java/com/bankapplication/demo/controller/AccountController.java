package com.bankapplication.demo.controller;

import com.bankapplication.demo.model.Accounts;
import com.bankapplication.demo.repository.AccountsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountsRepository accountsRepository;

    public AccountController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id){
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts!= null){
            return accounts;
        }else {
            return null;
        }
    }
}
