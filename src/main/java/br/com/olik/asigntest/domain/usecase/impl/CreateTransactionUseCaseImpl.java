package br.com.olik.asigntest.domain.usecase.impl;

import br.com.olik.asigntest.domain.entity.ECreateTransaction;
import br.com.olik.asigntest.domain.usecase.CreateTransactionUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    @Override
    public BigDecimal execute(ECreateTransaction eCreateTransaction) {
        return null;
    }
}
