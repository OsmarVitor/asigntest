package br.com.olik.asigntest.app.presentation;

import br.com.olik.asigntest.app.dto.TransactionDto;
import java.math.BigDecimal;

public interface WalletPresenter {

  BigDecimal getWalletAmount(Long userId);

  BigDecimal createWalletTransaction(TransactionDto transactionDto);
}
