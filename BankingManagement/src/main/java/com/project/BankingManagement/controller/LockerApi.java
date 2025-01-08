package com.project.BankingManagement.controller;

import com.project.BankingManagement.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/lockers")
public class LockerApi {

    @Autowired
    private LockerService lockerService;

    // Check the availability status of a locker by its ID
    @GetMapping("/{lockerId}/status")
    public ResponseEntity<Boolean> checkLockerStatus(@PathVariable Long lockerId) {
        try {
            boolean isAvailable = lockerService.checkLockerStatus(lockerId);
            return ResponseEntity.ok(isAvailable);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(false); // Return 404 if the locker is not found
        }
    }
}
