package com.easybank.loanservice.service.core;

import com.easybank.common.service.core.CrudService;
import com.easybank.loanservice.service.dto.LoanDTO;

import java.util.List;

public interface LoanService extends CrudService<LoanDTO, Long> {
    List<LoanDTO> findAllByCustomerId(Long customerId);
}
