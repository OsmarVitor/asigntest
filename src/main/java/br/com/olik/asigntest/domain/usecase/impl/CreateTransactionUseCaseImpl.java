package br.com.olik.asigntest.domain.usecase.impl;

import br.com.olik.asigntest.domain.entity.EWallet;
import br.com.olik.asigntest.domain.gateway.UpdateWalletGateway;
import br.com.olik.asigntest.domain.usecase.CreateTransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private final UpdateWalletGateway updateWalletGateway;

    @Override
    public BigDecimal execute(EWallet eWalletCreateTransaction) {
        var eWalletUpdated = updateWalletGateway.createWalletTransaction(eWalletCreateTransaction);
        return eWalletUpdated.getAmount();
    }
}
