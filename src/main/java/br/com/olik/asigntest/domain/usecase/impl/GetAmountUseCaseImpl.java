package br.com.olik.asigntest.domain.usecase.impl;

import br.com.olik.asigntest.domain.entity.ERetrieveWallet;
import br.com.olik.asigntest.domain.gateway.GetWalletGateway;
import br.com.olik.asigntest.domain.usecase.GetAmountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class GetAmountUseCaseImpl implements GetAmountUseCase {

    private final GetWalletGateway getWalletGateway;

    @Override
    public BigDecimal execute(Long userId) {
        ERetrieveWallet eRetrieveWallet = getWalletGateway.findWallet(userId);
        return eRetrieveWallet.getAmount();
    }
}
