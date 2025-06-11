package br.com.olik.asigntest.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class EWallet {

    BigDecimal amount;
    Long userId;
}
