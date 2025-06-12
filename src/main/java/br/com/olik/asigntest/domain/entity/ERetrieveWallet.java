package br.com.olik.asigntest.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ERetrieveWallet {
    BigDecimal amount;
    Long userId;
    String type;
}
