package br.com.olik.asigntest.infra.dataprovider;

import br.com.olik.asigntest.domain.entity.ERetrieveWallet;
import br.com.olik.asigntest.domain.entity.EWallet;
import br.com.olik.asigntest.domain.gateway.GetWalletGateway;
import br.com.olik.asigntest.domain.gateway.UpdateWalletGateway;
import br.com.olik.asigntest.infra.db.model.Wallet;
import br.com.olik.asigntest.infra.db.repository.WalletRepository;
import br.com.olik.asigntest.infra.exception.ModelNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class WalletDataProvider implements GetWalletGateway, UpdateWalletGateway {

    private final WalletRepository walletRepository;

    @Override
    public ERetrieveWallet findWallet(Long userId) {
        Wallet wallet = walletRepository.findByUserId(userId);
        if(Objects.isNull(wallet))
            throw new ModelNotFoundException("Wallet not found for userId " + userId);
        return ERetrieveWallet.builder()
                .userId(wallet.getUserId())
                .amount(wallet.getAmount())
                .type(wallet.getType().name())
                .build();
    }

    @Override
    public EWallet createWalletTransaction(EWallet eWalletCreateTransaction) {
        Long userId = eWalletCreateTransaction.getUserId();
        Wallet wallet = walletRepository.findByUserId(userId);
        if(Objects.isNull(wallet))
            throw new ModelNotFoundException("Wallet not found for userId " + userId);
        wallet.setAmount(wallet.getAmount().add(eWalletCreateTransaction.getAmount()));
        walletRepository.save(wallet);
        return EWallet.builder()
                .userId(wallet.getUserId())
                .amount(wallet.getAmount())
                .build();
    }
}
