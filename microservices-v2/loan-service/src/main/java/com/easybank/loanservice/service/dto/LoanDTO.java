package com.easybank.loanservice.service.dto;

import com.easybank.loanservice.entity.enumerate.LoanType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LoanDTO {
    private Long id;
    private Long customerId;
    private LocalDate startDate;
    private LoanType loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    private String createdDate;
}
