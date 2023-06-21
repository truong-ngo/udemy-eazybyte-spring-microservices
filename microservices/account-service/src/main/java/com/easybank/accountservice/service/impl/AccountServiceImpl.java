package com.easybank.accountservice.service.impl;

import com.easybank.accountservice.repository.AccountRepo;
import com.easybank.accountservice.service.core.AccountService;
import com.easybank.accountservice.service.dto.AccountDTO;
import com.easybank.accountservice.service.mapper.AccountMapper;
import com.easybank.accountservice.service.mapper.CustomerMapper;
import com.easybank.common.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final AccountRepo accountRepo;
    private final AccountMapper accountMapper;
    private final CustomerMapper customerMapper;

    @Override
    public List<AccountDTO> findAllByCustomer(CustomerDTO customerDTO) {
        log.info("Request to get accounts with customer: {}", customerDTO);
        return accountMapper.toDtoList(accountRepo.findAllByCustomer(customerMapper.toEntity(customerDTO)));
    }

    @Override
    public AccountDTO findById(Long aLong) {
        return null;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO delete(Long aLong) {
        return null;
    }
}
