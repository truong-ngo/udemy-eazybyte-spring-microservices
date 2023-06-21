package com.easybank.accountservice.rest;

import com.easybank.accountservice.service.core.AccountService;
import com.easybank.accountservice.service.dto.AccountDTO;
import com.easybank.common.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountResource {

    private final AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<AccountDTO> getAccount(@RequestBody CustomerDTO customer) {
        AccountDTO body = accountService.findAllByCustomer(customer).stream().findFirst().orElse(null);
        return ResponseEntity.ok(body);
    }
}
