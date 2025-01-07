package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Transaction type is required.")
    private String transactionType; //debit, credit


    @NotNull(message = "Amount is required.")
    @Min(value = 0, message = "Transaction amount must be positive.")
    private Double amount;


    private LocalDateTime transactionDate;

    @ManyToOne
    private User user;
}