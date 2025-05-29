package com.example.springstartherechapter12.controller;

import com.example.springstartherechapter12.model.Account;
import com.example.springstartherechapter12.model.TransferRequest;
import com.example.springstartherechapter12.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    // We use the HTTP POST method for the /transfer endpoint because it operates changes in the database's data.
    @PostMapping("/transfer")
    // We use a request body to get the needed values (source account ID, destination account ID, and amount) to be transferred.
     public void transferMoney(@RequestBody TransferRequest request) {
        // We call the service transferMoney() method, the transactional method that implements the transfer money use case.
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts")
    // We use an optional request parameter to get the name for which we want to return the account details.
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        // If no name is provided in the optional request parameter, we return all the account details.
        if (name == null) {
            return transferService.getAllAccounts();
            // If a nanme is provided in the request parameter, we only return the account details for the given name.
        } else {
            return transferService.findAccountsByName(name);
        }
    }
}
