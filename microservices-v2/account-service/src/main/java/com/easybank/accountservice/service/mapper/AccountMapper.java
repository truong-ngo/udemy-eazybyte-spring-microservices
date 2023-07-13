package com.easybank.accountservice.service.mapper;

import com.easybank.accountservice.entity.Account;
import com.easybank.accountservice.service.dto.AccountDTO;
import com.easybank.common.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface AccountMapper extends EntityMapper<Account, AccountDTO> {
}
