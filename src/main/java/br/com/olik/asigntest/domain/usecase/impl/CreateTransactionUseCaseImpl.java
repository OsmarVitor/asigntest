package br.com.olik.asigntest.domain.usecase.impl;

import br.com.olik.asigntest.domain.entity.ERetrieveWallet;
import br.com.olik.asigntest.domain.entity.EWallet;
import br.com.olik.asigntest.domain.exception.TransactionBadRequestException;
import br.com.olik.asigntest.domain.gateway.GetWalletGateway;
import br.com.olik.asigntest.domain.gateway.UpdateWalletGateway;
import br.com.olik.asigntest.domain.usecase.CreateTransactionUseCase;
import br.com.olik.asigntest.domain.usecase.enums.AccountTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private final UpdateWalletGateway updateWalletGateway;

    private final GetWalletGateway getWalletGateway;

    @Override
    public BigDecimal execute(EWallet eWalletCreateTransaction) {
        ERetrieveWallet eRetrieveWallet = getWalletGateway.findWallet(eWalletCreateTransaction.getUserId());

        if(eRetrieveWallet.getType().equals(AccountTypeEnum.ITAU.name())
        && eRetrieveWallet.getAmount().add(eWalletCreateTransaction.getAmount()).compareTo(BigDecimal.ZERO) < 0){
            throw new TransactionBadRequestException("Transaction declined, insufficient balance");
        }

        var eWalletUpdated = updateWalletGateway.createWalletTransaction(eWalletCreateTransaction);
        return eWalletUpdated.getAmount();
    }
}
