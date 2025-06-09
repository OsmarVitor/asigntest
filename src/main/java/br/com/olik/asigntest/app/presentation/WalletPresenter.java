package br.com.olik.asigntest.app.presentation;

import br.com.olik.asigntest.app.dto.TransactionDto;

import java.math.BigDecimal;

public interface WalletPresenter {

    BigDecimal retrieveAmount(Long userId);

    BigDecimal createTransaction(TransactionDto transactionDto);

}
