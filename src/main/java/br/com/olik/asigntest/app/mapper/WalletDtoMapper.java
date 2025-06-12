package br.com.olik.asigntest.app.mapper;

import br.com.olik.asigntest.app.dto.TransactionDto;
import br.com.olik.asigntest.domain.entity.EWallet;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WalletDtoMapper {

  public static EWallet toEntity(TransactionDto transactionDto) {
    return EWallet.builder()
        .userId(transactionDto.getUserId())
        .amount(transactionDto.getAmount())
        .build();
  }
}
