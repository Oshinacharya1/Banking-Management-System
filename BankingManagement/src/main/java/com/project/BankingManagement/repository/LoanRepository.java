package com.project.BankingManagement.repository;

import com.project.BankingManagement.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT u FROM Loan u WHERE u.email = :email")
    List<Loan> findAllByEmail(@Param("email") String email);

}
