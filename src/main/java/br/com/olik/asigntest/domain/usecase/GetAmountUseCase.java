package br.com.olik.asigntest.domain.usecase;

import java.math.BigDecimal;

public interface GetAmountUseCase {

  BigDecimal execute(Long userId);
}
