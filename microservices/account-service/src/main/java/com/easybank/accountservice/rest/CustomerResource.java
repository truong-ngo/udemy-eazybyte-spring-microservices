package com.easybank.accountservice.rest;

import com.easybank.accountservice.service.core.CustomerService;
import com.easybank.common.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id, @RequestHeader("eazybank-correlation-id") String header) {
        return ResponseEntity.ok(customerService.findById(id));
    }
}
