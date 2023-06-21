package com.easybank.loanservice.rest;

import com.easybank.common.service.dto.CustomerDTO;
import com.easybank.loanservice.service.core.LoanService;
import com.easybank.loanservice.service.dto.LoanDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanResource {

    private final LoanService loanService;

    @PostMapping("/loans")
    public ResponseEntity<List<LoanDTO>> getLoans(@RequestBody CustomerDTO customer) {
        List<LoanDTO> body = loanService.findAllByCustomerId(customer.getId());
        return ResponseEntity.ok(body);
    }
}
