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

    @Column(nullable = false)
    private String type; // HOME, CAR, PERSONAL

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Double interestRate;

    @Column(nullable = false)
    private String status; // PENDING, APPROVED, REJECTED

    @ManyToOne
    private User user;
}
