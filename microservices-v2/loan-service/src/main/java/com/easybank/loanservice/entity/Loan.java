package com.easybank.loanservice.entity;

import com.easybank.loanservice.entity.enumerate.LoanType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name = "loan_type")
    @Enumerated(value = EnumType.STRING)
    private LoanType loanType;

    @Column(name = "total_loan")
    private int totalLoan;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Column(name = "outstanding_amount")
    private int outstandingAmount;

    @Column(name = "created_date")
    private String createdDate;
}
