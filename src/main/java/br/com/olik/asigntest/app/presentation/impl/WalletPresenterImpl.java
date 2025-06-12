package br.com.olik.asigntest.app.presentation.impl;

import br.com.olik.asigntest.app.dto.TransactionDto;
import br.com.olik.asigntest.app.mapper.WalletDtoMapper;
import br.com.olik.asigntest.app.presentation.WalletPresenter;
import br.com.olik.asigntest.domain.usecase.CreateTransactionUseCase;
import br.com.olik.asigntest.domain.usecase.GetAmountUseCase;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletPresenterImpl implements WalletPresenter {

  private final CreateTransactionUseCase createTransactionUseCase;

  private final GetAmountUseCase getAmountUseCase;

  @Override
  public BigDecimal getWalletAmount(Long userId) {
    return getAmountUseCase.execute(userId);
  }

  @Override
  public BigDecimal createWalletTransaction(TransactionDto transactionDto) {
    return createTransactionUseCase.execute(WalletDtoMapper.toEntity(transactionDto));
  }
}
