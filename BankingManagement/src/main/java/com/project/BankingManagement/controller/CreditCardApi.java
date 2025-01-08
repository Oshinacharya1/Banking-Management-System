package com.project.BankingManagement.controller;

import com.project.BankingManagement.entity.CreditCard;
import com.project.BankingManagement.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditCards")
public class CreditCardApi {

    @Autowired
    private CreditCardService creditCardService;

    // Add a new credit card
    @PostMapping
    public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditCard) {
        CreditCard savedCard = creditCardService.addCreditCard(creditCard);
        return ResponseEntity.ok(savedCard);
    }

    // Get a credit card by its ID
    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
        CreditCard creditCard = creditCardService.getCreditCardById(id);
        if (creditCard != null) {
            return ResponseEntity.ok(creditCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

