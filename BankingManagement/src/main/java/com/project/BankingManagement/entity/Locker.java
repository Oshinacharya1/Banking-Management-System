package com.project.BankingManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String lockerNumber;


    @Column(nullable = false)
    private Boolean isAvailable; // status available or not

    @ManyToOne
    private User user;
}
