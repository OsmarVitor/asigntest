package br.com.olik.asigntest.infra.dataprovider;

import br.com.olik.asigntest.domain.entity.EWallet;
import br.com.olik.asigntest.domain.gateway.GetWalletGateway;
import br.com.olik.asigntest.domain.gateway.UpdateWalletGateway;
import br.com.olik.asigntest.infra.db.model.Wallet;
import br.com.olik.asigntest.infra.db.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletDataProvider implements GetWalletGateway, UpdateWalletGateway {

    private final WalletRepository walletRepository;

    @Override
    public EWallet findWallet(Long userId) {
        Wallet wallet = walletRepository.findByUserId(userId);
        return EWallet.builder()
                .userId(wallet.getUserId())
                .amount(wallet.getAmount())
                .build();
    }

    @Override
    public EWallet createWalletTransaction(EWallet eWalletCreateTransaction) {
        Wallet wallet = walletRepository.findByUserId(eWalletCreateTransaction.getUserId());
        wallet.getAmount().add(eWalletCreateTransaction.getAmount());
        walletRepository.save(wallet);
        return EWallet.builder()
                .userId(wallet.getUserId())
                .amount(wallet.getAmount())
                .build();
    }
}
