package com.easybank.accountservice.service.core;

import com.easybank.accountservice.service.dto.AccountDTO;
import com.easybank.common.service.core.CrudService;
import com.easybank.common.service.dto.CustomerDTO;

import java.util.List;

public interface AccountService extends CrudService<AccountDTO, Long> {
    List<AccountDTO> findAllByCustomer(CustomerDTO customerDTO);
}
