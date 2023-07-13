package com.easybank.cardservice.service.dto;

import com.easybank.cardservice.entity.enumerate.CardType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CardDTO {
    private Long id;
    private int customerId;
    private String cardNumber;
    private CardType cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
    private LocalDate createdDate;
}
