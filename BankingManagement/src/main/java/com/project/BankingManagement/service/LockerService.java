package com.project.BankingManagement.service;


import com.project.BankingManagement.entity.Locker;
import com.project.BankingManagement.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class LockerService {
    @Autowired
    private LockerRepository lockerRepository;

    public boolean checkLockerStatus(Long lockerId) {
        Locker locker = lockerRepository.findById(lockerId)
                .orElseThrow(() -> new NoSuchElementException("Locker not found with ID: " + lockerId));
        if (!locker.getAvailable()) {
            System.out.println("Locker is already booked.");
            return false;
        }
        return true;
    }
}
