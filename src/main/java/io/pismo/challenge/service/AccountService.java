package io.pismo.challenge.service;

import io.pismo.challenge.bean.AccountRequestDTO;
import io.pismo.challenge.model.Account;
import io.pismo.challenge.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(AccountRequestDTO accountRequestDTO) {
        var account = new Account();
        account.setDocumentNumber(accountRequestDTO.getDocumentNumber());

        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }
}
