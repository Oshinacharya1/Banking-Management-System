package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Card number is required.")
    @Column(unique = true, nullable = false)
    private String cardNumber;


    @NotNull(message = "Credit limit is required.")
    @Min(value = 1000, message = "Credit limit must be at least 1000.")
    private  Double creditLimit;


    @NotNull(message = "Balance is required.")
    private  Double balance;

    @ManyToOne
    private User user;

}
