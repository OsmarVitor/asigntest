package br.com.olik.asigntest.app.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDto {
    private Long userId;
    private BigDecimal amount;
}
