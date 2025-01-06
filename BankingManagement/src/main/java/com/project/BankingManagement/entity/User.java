package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String role; //customer, employee, admin

}
