package com.example.springstartherechapter12.service;

import com.example.springstartherechapter12.exceptions.AccountNotFoundException;
import com.example.springstartherechapter12.model.Account;
import com.example.springstartherechapter12.repository.AccountRepository;
import com.example.springstartherechapter12.repository.AccountRepositoryForJDBCTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
//    private final AccountRepositoryForJDBCTemplate accountRepositoryForJDBCTemplate;
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional // We wrap the use case logic in a transaction to avoid data inconsistencies if any instruction fails.
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        // We get the sender and receiver's account details.

//        Account sender = accountRepositoryForJDBCTemplate.findAccountById(idSender);
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
//        Account receiver = accountRepositoryForJDBCTemplate.findAccountById(idReceiver);
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

        // We calculate the new amounts by subtracting the transferred value from the sender account and adding it to the destination account.
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        // We change the account's amounts in the database
//        accountRepositoryForJDBCTemplate.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idSender, senderNewAmount);
//        accountRepositoryForJDBCTemplate.changeAmount(idReceiver, receiverNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        // We throw a runtime exception at the end of the service method to simulate a problem that occurred in the transaction.
//        throw new RuntimeException("Oh no! Something went wrong!");
    }

    public Iterable<Account> getAllAccounts() {
        // AccountRepository inherits this method from the Spring Data CrudRepository interface.
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
//        return accountRepositoryForJDBCTemplate.findAllAccounts();
        return accountRepository.findAccountsByName(name);
    }
}
