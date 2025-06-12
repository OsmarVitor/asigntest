package br.com.olik.asigntest.app.rest.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.olik.asigntest.infra.db.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
@AutoConfigureMockMvc
public class WalletControllerTest {

  private final MockMvc mockMvc;
  private final WalletRepository walletRepository;

  @Autowired
  public WalletControllerTest(MockMvc mockMvc, WalletRepository walletRepository) {
    this.mockMvc = mockMvc;
    this.walletRepository = walletRepository;
  }

  @Test
  @Transactional
  void shouldMakeItauTransactionAndRemainZeroAmount() throws Exception {
    Long userId = 2L;

    assertEquals(10, walletRepository.findByUserId(userId).getAmount().intValue());

    mockMvc
        .perform(
            post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": " + userId + ", \n" + "\"amount\": -10.0}"))
        .andExpect(status().isOk());

    assertEquals(0, walletRepository.findByUserId(userId).getAmount().intValue());
  }

  @Test
  @Transactional
  void shouldNotMakeItauTransaction() throws Exception {
    Long userId = 2L;

    assertEquals(10, walletRepository.findByUserId(userId).getAmount().intValue());

    mockMvc
        .perform(
            post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": " + userId + ", \n" + "\"amount\": -10.1}"))
        .andExpect(status().isBadRequest());

    assertEquals(10, walletRepository.findByUserId(userId).getAmount().intValue());
  }

  @Test
  @Transactional
  void shouldMakeSantanderTransaction() throws Exception {
    Long userId = 1L;

    assertEquals(7, walletRepository.findByUserId(userId).getAmount().intValue());

    mockMvc
        .perform(
            post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": " + userId + ", \n" + "\"amount\": -5.0}"))
        .andExpect(status().isOk());

    assertEquals(2, walletRepository.findByUserId(userId).getAmount().intValue());
  }

  @Test
  @Transactional
  void shouldMakeSantanderTransactionAndHaveNegativeAmount() throws Exception {
    Long userId = 1L;

    assertEquals(7, walletRepository.findByUserId(userId).getAmount().intValue());

    mockMvc
        .perform(
            post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": " + userId + ", \n" + "\"amount\": -10.0}"))
        .andExpect(status().isOk());

    assertEquals(-3, walletRepository.findByUserId(userId).getAmount().intValue());
  }
}
