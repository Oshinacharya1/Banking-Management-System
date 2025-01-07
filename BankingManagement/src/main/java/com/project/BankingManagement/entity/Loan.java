package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor

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

    public Long getId() {
        return id;
    }


    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
