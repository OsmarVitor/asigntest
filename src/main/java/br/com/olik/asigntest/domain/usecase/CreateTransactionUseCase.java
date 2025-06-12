package br.com.olik.asigntest.domain.usecase;

import br.com.olik.asigntest.domain.entity.EWallet;
import java.math.BigDecimal;

public interface CreateTransactionUseCase {

  BigDecimal execute(EWallet eWallet);
}
