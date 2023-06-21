package com.easybank.cardservice.client;

import com.easybank.common.service.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service", url = "localhost:8080")
public interface AccountClient {
    @GetMapping("/customers/{id}")
    CustomerDTO getCustomer(@PathVariable Long id);
}
