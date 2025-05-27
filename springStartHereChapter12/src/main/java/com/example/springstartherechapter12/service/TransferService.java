package com.example.springstartherechapter12.service;

import com.example.springstartherechapter12.model.Account;
import com.example.springstartherechapter12.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional // We use the @Transactional annotation to instruct Spring to wrap the method's calls in transactions.
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        // We get the account's details to find the current amount in each account.
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        // We calculate the new amount for the sender account.
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);

        // We calculate the new amount for the destination account.
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        // We set the new amount value for the sender account.
        accountRepository.changeAmount(idSender, senderNewAmount);

        // We set the new amount value for the destination account.
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
