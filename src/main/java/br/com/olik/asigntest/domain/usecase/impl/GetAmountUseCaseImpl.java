package br.com.olik.asigntest.domain.usecase.impl;

import br.com.olik.asigntest.domain.entity.ERetrieveWallet;
import br.com.olik.asigntest.domain.gateway.GetWalletGateway;
import br.com.olik.asigntest.domain.usecase.GetAmountUseCase;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAmountUseCaseImpl implements GetAmountUseCase {

  Logger logger = LoggerFactory.getLogger(GetAmountUseCaseImpl.class);

  private final GetWalletGateway getWalletGateway;

  @Override
  public BigDecimal execute(Long userId) {
    logger.info("Execute get amount ");
    ERetrieveWallet eRetrieveWallet = getWalletGateway.findWallet(userId);
    return eRetrieveWallet.getAmount();
  }
}
