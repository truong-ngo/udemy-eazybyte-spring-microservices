package com.easybank.accountservice.service.mapper;

import com.easybank.accountservice.entity.Customer;
import com.easybank.common.service.dto.CustomerDTO;
import com.easybank.common.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<Customer, CustomerDTO> {
}
