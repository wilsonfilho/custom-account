package io.pismo.challenge.controller;

import io.pismo.challenge.bean.AccountRequestDTO;
import io.pismo.challenge.model.Account;
import io.pismo.challenge.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AccountControllerTests {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test
    public void testCreateAccountSuccess() throws Exception {
        // Arrange
        Account account = new Account();
        account.setId(1L);
        account.setDocumentNumber("12345678900");

        when(accountService.createAccount(any(AccountRequestDTO.class))).thenReturn(account);

        // Act & Assert
        mockMvc.perform(post("/accounts/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"documentNumber\": \"12345678900\" }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(account.getId()))
                .andExpect(jsonPath("$.documentNumber").value(account.getDocumentNumber()));
    }

    @Test
    public void testGetAccount_Success() throws Exception {

        // Arrange
        Account account = new Account();
        account.setId(1L);
        account.setDocumentNumber("12345678900");

        when(accountService.getAccountById(1L)).thenReturn(Optional.of(account));

        // Act & Assert
        mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(account.getId()))
                .andExpect(jsonPath("$.documentNumber").value(account.getDocumentNumber()));
    }

    @Test
    public void testGetAccount_NotFound() throws Exception {

        when(accountService.getAccountById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isNotFound());
    }
}
