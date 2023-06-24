package com.easybank.loanservice.client;

import com.easybank.common.service.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("accounts")
public interface AccountClient {
    @GetMapping("/customers/{id}")
    CustomerDTO getCustomer(@PathVariable Long id);
}
