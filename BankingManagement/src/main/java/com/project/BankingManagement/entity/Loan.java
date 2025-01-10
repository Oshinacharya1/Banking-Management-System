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

    @NotNull(message = "Name is required.")
    private String name;

    @NotNull(message = "Address is required.")
    private String address;

    @NotNull(message = "Phone is required.")
    private String phone;

    @NotNull(message = "Email is required.")
    private String email;

    @NotNull(message = "Loan amount is required.")
    @Min(value = 5000, message = "Loan amount must be at least 5000.")
    private BigDecimal amount;

    //@NotNull(message = "Interest rate is required.")
    //@Min(value = 1, message = "Interest rate cannot be 0 or negative.")
    // Default interest rate
    private Double interestRate = 6.8;

    @NotBlank(message = "Status is required.")
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
