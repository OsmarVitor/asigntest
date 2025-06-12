package br.com.olik.asigntest.app.dto;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class TransactionDto {
    private Long userId;
    private BigDecimal amount;
}
