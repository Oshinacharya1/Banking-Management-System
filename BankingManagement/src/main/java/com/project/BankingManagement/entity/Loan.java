package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Loan type is required.")
    private String loanType; // HOME, CAR, PERSONAL

    @NotNull(message = "Loan amount is required.")
    @Min(value = 5000, message = "Loan amount must be at least 5000.")
    private BigDecimal amount;

    @NotNull(message = "Interest rate is required.")
    @Min(value = 1, message = "Interest rate cannot be 0 or negative.")
    private Double interestRate;

    @NotBlank(message = "Status is required.")
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

    @ManyToOne
    private User user;
}
