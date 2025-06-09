package br.com.olik.asigntest.domain.usecase;

import java.math.BigDecimal;

public interface RetrieveAmountUseCase {

    BigDecimal execute(Long userId);
}
