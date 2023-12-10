package com.bankapplication.demo.controller;

import com.bankapplication.demo.model.AccountTransactions;
import com.bankapplication.demo.model.Customer;
import com.bankapplication.demo.repository.AccountTransactionsRepository;
import com.bankapplication.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {
    private final AccountTransactionsRepository accountTransactionsRepository;
    private final CustomerRepository customerRepository;

    public BalanceController(AccountTransactionsRepository accountTransactionsRepository, CustomerRepository customerRepository) {
        this.accountTransactionsRepository = accountTransactionsRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<AccountTransactions> accountTransactions = accountTransactionsRepository
                    .findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
            if (accountTransactions != null) {
                return accountTransactions;
            }
        }
        return null;
    }
}
