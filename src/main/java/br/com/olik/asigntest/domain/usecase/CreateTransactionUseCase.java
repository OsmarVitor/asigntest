package br.com.olik.asigntest.domain.usecase;

import br.com.olik.asigntest.domain.entity.ECreateTransaction;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {

    BigDecimal execute(ECreateTransaction eCreateTransaction);
}
