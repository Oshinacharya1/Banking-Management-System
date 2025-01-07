package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String cardNumber;


    @Column(nullable = false)
    private  Double limit;


    @Column(nullable = false)
    private  Double balance;

    @ManyToOne
    private User user;

}
