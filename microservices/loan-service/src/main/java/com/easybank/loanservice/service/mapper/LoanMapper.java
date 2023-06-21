package com.easybank.loanservice.service.mapper;

import com.easybank.common.service.mapper.EntityMapper;
import com.easybank.loanservice.entity.Loan;
import com.easybank.loanservice.service.dto.LoanDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper extends EntityMapper<Loan, LoanDTO> {

}
