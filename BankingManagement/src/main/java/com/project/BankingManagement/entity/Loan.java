package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // HOME, CAR, PERSONAL

    private BigDecimal amount;

    private Double interestRate;

    private String status; // PENDING, APPROVED, REJECTED

    @ManyToOne
    private User user;
}
