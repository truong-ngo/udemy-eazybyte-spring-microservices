package com.easybank.accountservice.entity;

import com.easybank.accountservice.entity.enumerate.AccountType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name="account_type")
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
