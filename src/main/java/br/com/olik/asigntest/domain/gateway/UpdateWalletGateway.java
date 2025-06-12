package br.com.olik.asigntest.domain.gateway;

import br.com.olik.asigntest.domain.entity.EWallet;

public interface UpdateWalletGateway {

  EWallet createWalletTransaction(EWallet eWalletCreateTransaction);
}
