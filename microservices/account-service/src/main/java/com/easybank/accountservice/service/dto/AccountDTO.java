package com.easybank.accountservice.service.dto;

import com.easybank.accountservice.entity.enumerate.AccountType;
import com.easybank.common.service.dto.CustomerDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AccountDTO {
    private Long accountNumber;
    private CustomerDTO customer;
    private AccountType accountType;
    private String branchAddress;
    private LocalDate createdDate;
}
