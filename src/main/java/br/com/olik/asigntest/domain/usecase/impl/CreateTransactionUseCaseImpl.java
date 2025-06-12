package br.com.olik.asigntest.domain.usecase.impl;

import br.com.olik.asigntest.domain.entity.ERetrieveWallet;
import br.com.olik.asigntest.domain.entity.EWallet;
import br.com.olik.asigntest.domain.exception.TransactionBadRequestException;
import br.com.olik.asigntest.domain.gateway.GetWalletGateway;
import br.com.olik.asigntest.domain.gateway.UpdateWalletGateway;
import br.com.olik.asigntest.domain.usecase.CreateTransactionUseCase;
import br.com.olik.asigntest.domain.usecase.enums.AccountTypeEnum;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    Logger logger = LoggerFactory.getLogger(CreateTransactionUseCaseImpl.class);

    private final UpdateWalletGateway updateWalletGateway;

    private final GetWalletGateway getWalletGateway;

    @Override
    public BigDecimal execute(EWallet eWalletCreateTransaction) {
        logger.info("Execute transaction for userId {}", eWalletCreateTransaction.getUserId());
        ERetrieveWallet eRetrieveWallet = getWalletGateway.findWallet(eWalletCreateTransaction.getUserId());

        if(eRetrieveWallet.getType().equals(AccountTypeEnum.ITAU.name())
        && eRetrieveWallet.getAmount().add(eWalletCreateTransaction.getAmount()).compareTo(BigDecimal.ZERO) < 0){
            logger.error("Transaction declined, wallet type {} cannot be negative",AccountTypeEnum.ITAU.name());
            throw new TransactionBadRequestException("Transaction declined, insufficient balance");
        }
        var eWalletUpdated = updateWalletGateway.createWalletTransaction(eWalletCreateTransaction);
        return eWalletUpdated.getAmount();
    }
}
