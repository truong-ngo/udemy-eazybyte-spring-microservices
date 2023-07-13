package com.easybank.accountservice.repository;

import com.easybank.accountservice.entity.Account;
import com.easybank.accountservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> findAllByCustomer(Customer customer);
}
