package com.bankapplication.demo.controller;

import com.bankapplication.demo.model.Cards;
import com.bankapplication.demo.model.Customer;
import com.bankapplication.demo.repository.CardsRepository;
import com.bankapplication.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final CardsRepository cardsRepository;
    private final CustomerRepository customerRepository;

    public CardsController(CardsRepository cardsRepository, CustomerRepository customerRepository) {
        this.cardsRepository = cardsRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Cards> cards = cardsRepository.findByCustomerId(customers.get(0).getId());
            if (cards != null) {
                return cards;
            }
        }
        return null;

    }
}
