package br.com.olik.asigntest.domain.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EWallet {
  BigDecimal amount;
  Long userId;
}
