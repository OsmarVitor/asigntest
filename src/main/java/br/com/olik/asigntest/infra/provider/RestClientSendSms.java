package br.com.olik.asigntest.infra.provider;

import br.com.olik.asigntest.domain.gateway.SendSmsGateway;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestClientSendSms implements SendSmsGateway {

  Logger logger = LoggerFactory.getLogger(RestClientSendSms.class);

  private final RestTemplate restTemplate;

  @Override
  public void sendSms(Long userId) {
    logger.info("Starting send SMS of insufficient amount for userId {}", userId);
    // restTemplate.getForObject("mockUrl", String.class);
  }
}
