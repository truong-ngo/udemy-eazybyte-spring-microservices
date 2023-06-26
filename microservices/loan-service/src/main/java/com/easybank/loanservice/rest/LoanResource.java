package com.easybank.loanservice.rest;

import com.easybank.common.service.dto.CustomerDTO;
import com.easybank.loanservice.config.LoanConfig;
import com.easybank.loanservice.entity.Properties;
import com.easybank.loanservice.service.core.LoanService;
import com.easybank.loanservice.service.dto.LoanDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final LoanService loanService;
    private final LoanConfig loanConfig;

    @PostMapping("/loans")
    @Retry(name = "retryForCustomerDetails", fallbackMethod = "customDetailsFallback")
    public ResponseEntity<List<LoanDTO>> getLoans(@RequestBody CustomerDTO customer, @RequestHeader("eazybank-correlation-id") String headers) {
        log.info("Request to get Loans: {}", customer);
        List<LoanDTO> body = loanService.findAllByCustomerId(customer.getId(), headers);
        log.info("Response: {}", body);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/loans/properties")
    public Properties getPropertiesDetail() {
        return new Properties(loanConfig.getMsg(), loanConfig.getBuildVersion(), loanConfig.getMailDetails(), loanConfig.getActiveBranches());
    }

    private ResponseEntity<List<LoanDTO>> customDetailsFallback(CustomerDTO customer, Throwable throwable) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
