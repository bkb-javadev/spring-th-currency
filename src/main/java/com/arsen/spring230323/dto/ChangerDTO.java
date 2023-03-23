package com.arsen.spring230323.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChangerDTO {
    private String currency;
    private BigDecimal amount;
}
