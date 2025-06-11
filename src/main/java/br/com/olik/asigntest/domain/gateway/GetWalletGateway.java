package br.com.olik.asigntest.domain.gateway;

import br.com.olik.asigntest.domain.entity.EWallet;

public interface GetWalletGateway {

    EWallet findWallet(Long userId);
}
