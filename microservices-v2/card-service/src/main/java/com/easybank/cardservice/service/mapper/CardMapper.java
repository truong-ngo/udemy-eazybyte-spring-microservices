package com.easybank.cardservice.service.mapper;

import com.easybank.cardservice.entity.Card;
import com.easybank.cardservice.service.dto.CardDTO;
import com.easybank.common.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends EntityMapper<Card, CardDTO> {
}
