package com.easybank.cardservice.rest;

import com.easybank.cardservice.config.CardConfig;
import com.easybank.cardservice.entity.Properties;
import com.easybank.cardservice.service.core.CardService;
import com.easybank.cardservice.service.dto.CardDTO;
import com.easybank.common.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardResource {

    private final CardService cardService;
    private final CardConfig cardConfig;

    @PostMapping("/cards")
    public ResponseEntity<List<CardDTO>> getLoans(@RequestBody CustomerDTO customer) {
        List<CardDTO> body = cardService.findAllByCustomer(customer.getId());
        return ResponseEntity.ok(body);
    }

    @GetMapping("/cards/properties")
    public Properties getPropertiesDetail() {
        return new Properties(cardConfig.getMsg(), cardConfig.getBuildVersion(), cardConfig.getMailDetails(), cardConfig.getActiveBranches());
    }
}
