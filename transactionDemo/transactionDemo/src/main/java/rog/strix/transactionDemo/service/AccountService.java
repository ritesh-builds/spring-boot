package rog.strix.transactionDemo.service;

import org.springframework.stereotype.Service;
import rog.strix.transactionDemo.entity.Account;
import rog.strix.transactionDemo.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account){
        accountRepository.save(account);
    }
}
