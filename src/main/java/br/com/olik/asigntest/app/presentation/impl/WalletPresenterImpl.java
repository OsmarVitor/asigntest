package br.com.olik.asigntest.app.presentation.impl;

import br.com.olik.asigntest.app.dto.TransactionDto;
import br.com.olik.asigntest.app.mapper.WalletDtoMapper;
import br.com.olik.asigntest.app.presentation.WalletPresenter;
import br.com.olik.asigntest.domain.usecase.CreateTransactionUseCase;
import br.com.olik.asigntest.domain.usecase.RetrieveAmountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class WalletPresenterImpl implements WalletPresenter {

    private final CreateTransactionUseCase createTransactionUseCase;

    private final RetrieveAmountUseCase retrieveAmountUseCase;


    @Override
    public BigDecimal retrieveAmount(Long userId) {
        return retrieveAmountUseCase.execute(userId);
    }

    @Override
    public BigDecimal createTransaction(TransactionDto transactionDto) {
        return createTransactionUseCase.execute(WalletDtoMapper.toEntity(transactionDto));
    }
}
