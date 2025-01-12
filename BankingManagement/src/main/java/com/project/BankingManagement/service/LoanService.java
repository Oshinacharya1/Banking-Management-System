package com.project.BankingManagement.service;

import com.project.BankingManagement.entity.Loan;
import com.project.BankingManagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public Loan applyLoan(Loan loan) {
        loan.setStatus("PENDING");
        return loanRepository.save(loan);
    }

    public Loan approveLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new NoSuchElementException("Loan not found."));
        loan.setStatus("APPROVED");
        return loanRepository.save(loan);
    }

    public Loan rejectLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new NoSuchElementException("Loan not found."));
        loan.setStatus("REJECTED");
        return loanRepository.save(loan);
    }
    public Optional<Loan> getLoanById(Long loanId) {
        return loanRepository.findById(loanId);
    }

    public List<Loan> getAllLoansForUser(String emailId){
        String email = URLDecoder.decode(emailId, StandardCharsets.UTF_8);
        System.out.println("Decoded email: " + email);
        return loanRepository.findAllByEmail(email);
    }

    public List<Loan> getAllLoansForAdmin(){
        return loanRepository.findAll();
    }

}
