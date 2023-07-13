package com.easybank.cardservice.rest;

import com.easybank.cardservice.config.CardConfig;
import com.easybank.cardservice.entity.Properties;
import com.easybank.cardservice.service.core.CardService;
import com.easybank.cardservice.service.dto.CardDTO;
import com.easybank.common.service.dto.CustomerDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CardService cardService;
    private final CardConfig cardConfig;

    @PostMapping("/cards")
    @CircuitBreaker(name = "detailsForAccountSupport", fallbackMethod = "customDetailsFallback")
    public ResponseEntity<List<CardDTO>> getCards(@RequestBody CustomerDTO customer, @RequestHeader("eazybank-correlation-id") String header) {
        log.info("Request to get Cards: {}", customer);
        List<CardDTO> body = cardService.findAllByCustomer(customer.getId(), header);
        log.info("Response: {}", body);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/cards/properties")
    public Properties getPropertiesDetail() {
        return new Properties(cardConfig.getMsg(), cardConfig.getBuildVersion(), cardConfig.getMailDetails(), cardConfig.getActiveBranches());
    }

    private ResponseEntity<List<CardDTO>> customDetailsFallback(CustomerDTO customer, Throwable throwable) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
