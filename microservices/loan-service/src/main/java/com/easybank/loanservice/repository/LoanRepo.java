package com.easybank.loanservice.repository;

import com.easybank.loanservice.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {
    List<Loan> findAllByCustomerId(Long customerId);
}
