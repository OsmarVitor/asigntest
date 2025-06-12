package br.com.olik.asigntest.app.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TransactionDto {
  private Long userId;
  private BigDecimal amount;
}
