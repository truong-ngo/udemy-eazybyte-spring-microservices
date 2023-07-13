package com.easybank.cardservice.service.impl;

import com.easybank.cardservice.client.AccountClient;
import com.easybank.cardservice.repository.CardRepo;
import com.easybank.cardservice.service.core.CardService;
import com.easybank.cardservice.service.dto.CardDTO;
import com.easybank.cardservice.service.mapper.CardMapper;
import com.easybank.common.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CardRepo cardRepo;
    private final CardMapper cardMapper;
    private final AccountClient accountClient;

    @Override
    public List<CardDTO> findAllByCustomer(Long customerId, String header) {
        CustomerDTO customerDTO = accountClient.getCustomer(customerId, header);
        log.info("Request to get loan with customer: {}", customerDTO);
        return cardRepo.findAllByCustomerId(customerId).stream().map(cardMapper::toDto).toList();
    }

    @Override
    public CardDTO findById(Long aLong) {
        return null;
    }

    @Override
    public CardDTO save(CardDTO cardDTO) {
        return null;
    }

    @Override
    public CardDTO delete(Long aLong) {
        return null;
    }
}
