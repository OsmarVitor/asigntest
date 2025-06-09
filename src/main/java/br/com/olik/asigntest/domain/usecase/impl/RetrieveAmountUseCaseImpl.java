package br.com.olik.asigntest.domain.usecase.impl;

import br.com.olik.asigntest.domain.usecase.RetrieveAmountUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RetrieveAmountUseCaseImpl implements RetrieveAmountUseCase {

    @Override
    public BigDecimal execute(Long userId) {
        return null;
    }
}
