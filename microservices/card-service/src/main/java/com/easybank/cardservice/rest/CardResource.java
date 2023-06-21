package com.easybank.cardservice.rest;

import com.easybank.cardservice.service.core.CardService;
import com.easybank.cardservice.service.dto.CardDTO;
import com.easybank.common.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardResource {

    private final CardService cardService;

    @PostMapping("/cards")
    public ResponseEntity<List<CardDTO>> getLoans(@RequestBody CustomerDTO customer) {
        List<CardDTO> body = cardService.findAllByCustomer(customer.getId());
        return ResponseEntity.ok(body);
    }
}
