package com.easybank.loanservice.service.impl;

import com.easybank.common.service.dto.CustomerDTO;
import com.easybank.loanservice.client.AccountClient;
import com.easybank.loanservice.repository.LoanRepo;
import com.easybank.loanservice.service.core.LoanService;
import com.easybank.loanservice.service.dto.LoanDTO;
import com.easybank.loanservice.service.mapper.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final LoanRepo loanRepo;
    private final LoanMapper loanMapper;
    private final AccountClient accountClient;

    @Override
    public List<LoanDTO> findAllByCustomerId(Long customerId, String header) {
        CustomerDTO customerDTO = accountClient.getCustomer(customerId, header);
        log.info("Request to get loan with customer: {}", customerDTO);
        return loanRepo.findAllByCustomerId(customerId).stream().map(loanMapper::toDto).toList();
    }

    @Override
    public LoanDTO findById(Long aLong) {
        return null;
    }

    @Override
    public LoanDTO save(LoanDTO loanDTO) {
        return null;
    }

    @Override
    public LoanDTO delete(Long aLong) {
        return null;
    }
}
