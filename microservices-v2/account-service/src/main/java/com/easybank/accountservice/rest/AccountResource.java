package com.easybank.accountservice.rest;

import com.easybank.accountservice.config.AccountConfig;
import com.easybank.accountservice.entity.Properties;
import com.easybank.accountservice.service.core.AccountService;
import com.easybank.accountservice.service.dto.AccountDTO;
import com.easybank.common.service.dto.CustomerDTO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final AccountService accountService;
    private final AccountConfig accountConfig;

    @PostMapping("/accounts")
    @Timed(value = "getAccount.time", description = "Time taken to return Account")
    public ResponseEntity<AccountDTO> getAccount(@RequestBody CustomerDTO customer) {
        log.info("Request to get account: {}", customer);
        AccountDTO body = accountService.findAllByCustomer(customer).stream().findFirst().orElse(null);
        log.info("Response: {}", body);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/accounts/properties")
    @RateLimiter(name = "accountLimiter", fallbackMethod = "accountLimiterFallback")
    public Properties getPropertiesDetail() {
        return new Properties(accountConfig.getMsg(), accountConfig.getBuildVersion(), accountConfig.getMailDetails(), accountConfig.getActiveBranches());
    }

    private Properties accountLimiterFallback(Throwable throwable) {
        return new Properties();
    }
}
