package com.easybank.accountservice.service.impl;

import com.easybank.accountservice.entity.Customer;
import com.easybank.accountservice.repository.CustomerRepo;
import com.easybank.accountservice.service.core.CustomerService;
import com.easybank.accountservice.service.mapper.CustomerMapper;
import com.easybank.common.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO findById(Long id) {
        log.info("Request to get customer with id: {}", id);
        return customerRepo.findById(id).map(customerMapper::toDto).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        log.info("Request to save customer: {}", customerDTO);
        Customer customer = customerRepo.save(customerMapper.toEntity(customerDTO));
        return customerMapper.toDto(customer);
    }

    @Override
    public CustomerDTO delete(Long id) {
        log.info("Request to delete customer with id: {}", id);
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        customerRepo.delete(customer);
        return customerMapper.toDto(customer);
    }
}
