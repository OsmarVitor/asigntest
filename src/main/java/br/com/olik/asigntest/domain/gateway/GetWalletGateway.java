package br.com.olik.asigntest.domain.gateway;

import br.com.olik.asigntest.domain.entity.ERetrieveWallet;

public interface GetWalletGateway {

    ERetrieveWallet findWallet(Long userId);
}
