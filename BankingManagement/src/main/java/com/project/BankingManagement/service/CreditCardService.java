package com.project.BankingManagement.service;

import com.project.BankingManagement.entity.CreditCard;
import com.project.BankingManagement.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard addCreditCard(CreditCard creditCard) {
        System.out.println("Saving credit card to the database: ");
        return creditCardRepository.save(creditCard);
    }

    public CreditCard getCreditCardById(Long id) {
        Optional<CreditCard> creditCard = creditCardRepository.findById(id);
        if (creditCard.isPresent()) {
            System.out.println("Fetching credit card with ID: " + id);
            return creditCard.get();
        }
        System.out.println("Credit card with ID: " + id + " not found");
        return null; // Return null if the credit card does not exist
    }
    }

