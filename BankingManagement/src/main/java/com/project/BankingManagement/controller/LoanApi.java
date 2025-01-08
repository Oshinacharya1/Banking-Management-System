package com.project.BankingManagement.controller;

import com.project.BankingManagement.entity.Loan;
import com.project.BankingManagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanApi {

    @Autowired
    private LoanService loanService;

    // Apply for a loan
    @PostMapping
    public ResponseEntity<Loan> applyLoan(@RequestBody Loan loan) {
        Loan appliedLoan = loanService.applyLoan(loan);
        return ResponseEntity.ok(appliedLoan);
    }

    // Get loans by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Loan>> getUserLoans(@PathVariable Long userId) {
        List<Loan> userLoans = loanService.getUserLoans(userId);
        return ResponseEntity.ok(userLoans);
    }

    // Approve a loan
    @PutMapping("/{loanId}/approve")
    public ResponseEntity<Loan> approveLoan(@PathVariable Long loanId) {
        Loan approvedLoan = loanService.approveLoan(loanId);
        return ResponseEntity.ok(approvedLoan);
    }

    // Reject a loan
    @PutMapping("/{loanId}/reject")
    public ResponseEntity<Loan> rejectLoan(@PathVariable Long loanId) {
        Loan rejectedLoan = loanService.rejectLoan(loanId);
        return ResponseEntity.ok(rejectedLoan);
    }
}
