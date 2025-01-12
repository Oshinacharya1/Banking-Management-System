package com.project.BankingManagement.controller;

import com.project.BankingManagement.entity.Loan;
import com.project.BankingManagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/loans")
public class LoanApi {

    @Autowired
    private LoanService loanService;

    // Apply for a loan
    @PostMapping("/apply-loan")
    public ResponseEntity<Loan> applyLoan(@RequestBody Loan loan) {
        System.out.println("Loan request received for: " + loan.getName()+ "Amt: " + loan.getAmount());
        Loan appliedLoan = loanService.applyLoan(loan);
        return ResponseEntity.ok(appliedLoan);
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

    //FOR LOAN STATUS

    @GetMapping("/status/{loanId}")
    public ResponseEntity<String> getLoanStatus(@PathVariable Long loanId) {
        Optional<Loan> loan = loanService.getLoanById(loanId);
        if (loan.isPresent()) {
            return ResponseEntity.ok(loan.get().getStatus()); // Assuming `status` is a field in the `Loan` entity
        } else {
            return null;
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Loan>> getAllLoansForUser(@PathVariable String email) {
        List<Loan> loans = loanService.getAllLoansForUser(email);
        if(loans.isEmpty()){
            System.out.println("Loan application not found for: " + email);
            ResponseEntity.noContent();
        } else {
            return ResponseEntity.ok(loans);
        }
        return null;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Loan>> getAllLoansForAdmin() {
        List<Loan> loans = loanService.getAllLoansForAdmin();
        if(loans.isEmpty()){
            System.out.println("Loan applications not found");
            ResponseEntity.noContent();
        } else {
            System.out.println("First loan sample: " + loans.get(0).getId());
            return ResponseEntity.ok(loans);
        }
        return null;
    }
}
