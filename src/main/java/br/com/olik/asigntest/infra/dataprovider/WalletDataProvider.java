package br.com.olik.asigntest.infra.dataprovider;

import br.com.olik.asigntest.domain.entity.ERetrieveWallet;
import br.com.olik.asigntest.domain.entity.EWallet;
import br.com.olik.asigntest.domain.gateway.GetWalletGateway;
import br.com.olik.asigntest.domain.gateway.UpdateWalletGateway;
import br.com.olik.asigntest.infra.db.model.Wallet;
import br.com.olik.asigntest.infra.db.repository.WalletRepository;
import br.com.olik.asigntest.infra.exception.ModelNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class WalletDataProvider implements GetWalletGateway, UpdateWalletGateway {

    Logger logger = LoggerFactory.getLogger(WalletDataProvider.class);

    private final WalletRepository walletRepository;

    @Override
    public ERetrieveWallet findWallet(Long userId) {
        logger.info("Start find Wallet for userId {}", userId);
        Wallet wallet = findByUserId(userId);
        logger.info("Success to find Wallet for userId {}", userId);
        return ERetrieveWallet.builder()
                .userId(wallet.getUserId())
                .amount(wallet.getAmount())
                .type(wallet.getType().name())
                .build();
    }

    @Override
    public EWallet createWalletTransaction(EWallet eWalletCreateTransaction) {
        Long userId = eWalletCreateTransaction.getUserId();
        Wallet wallet = findByUserId(userId);
        wallet.setAmount(wallet.getAmount().add(eWalletCreateTransaction.getAmount()));
        walletRepository.save(wallet);
        logger.info("Success to finish transaction for userId {}", userId);
        return EWallet.builder()
                .userId(wallet.getUserId())
                .amount(wallet.getAmount())
                .build();
    }

    private Wallet findByUserId(Long userId) {
        Wallet wallet = walletRepository.findByUserId(userId);
        if (Objects.isNull(wallet)) {
            logger.error("Wallet not found for userId {}", userId);
            throw new ModelNotFoundException("Wallet not found for userId " + userId);
        }
        return wallet;
    }
}
