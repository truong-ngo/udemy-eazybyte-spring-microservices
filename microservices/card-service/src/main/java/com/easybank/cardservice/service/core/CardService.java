package com.easybank.cardservice.service.core;

import com.easybank.cardservice.service.dto.CardDTO;
import com.easybank.common.service.core.CrudService;
import com.easybank.common.service.dto.CustomerDTO;

import java.util.List;

public interface CardService extends CrudService<CardDTO, Long> {
    List<CardDTO> findAllByCustomer(Long customerId);
}
