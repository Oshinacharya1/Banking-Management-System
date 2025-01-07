package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "Username is required.")
    @Column(unique = true)
    private String username;

    @NotNull (message = "Password is required.")
    private String password;

    @NotNull
    private String role; //customer, employee, admin

}
