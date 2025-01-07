package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String type; //debit, credit


    @Column(nullable = false)
    private Double amount;


    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @ManyToOne
    private User user;
}