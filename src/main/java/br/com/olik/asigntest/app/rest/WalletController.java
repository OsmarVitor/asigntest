package br.com.olik.asigntest.app.rest;

import br.com.olik.asigntest.app.dto.TransactionDto;
import br.com.olik.asigntest.app.presentation.WalletPresenter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class WalletController {

    Logger logger = LoggerFactory.getLogger(WalletController.class);

    private final WalletPresenter walletPresenter;

    @GetMapping("/amount")
    public BigDecimal getAmount(Long userId) {
        logger.info("Start retrieve amount for userId {}", userId);
        return walletPresenter.getWalletAmount(userId);
    }

    @PostMapping("/transaction")
    public BigDecimal transaction(@RequestBody TransactionDto transactionDto) {
        logger.info("Start transaction {}", transactionDto);
        var response = walletPresenter.createWalletTransaction(transactionDto);
        logger.info("Wallet {}", response);
        return response;
    }
}
