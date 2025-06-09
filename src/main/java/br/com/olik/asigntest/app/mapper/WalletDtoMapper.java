package br.com.olik.asigntest.app.mapper;

import br.com.olik.asigntest.app.dto.TransactionDto;
import br.com.olik.asigntest.domain.entity.ECreateTransaction;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WalletDtoMapper {

    public static ECreateTransaction toEntity(TransactionDto transactionDto){
        return ECreateTransaction.builder().userId(transactionDto.getUserId()).amount(transactionDto.getAmount()).build();
    }
}
