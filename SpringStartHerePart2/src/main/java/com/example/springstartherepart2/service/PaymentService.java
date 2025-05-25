package com.example.springstartherepart2.service;

import com.example.springstartherepart2.excecptions.NotEnoughMoneyExecption;
import com.example.springstartherepart2.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyExecption();
    }
}
