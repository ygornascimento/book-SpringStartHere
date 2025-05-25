package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.Payment;
import com.example.springstartherepart2.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

//@RestController
//public class PaymentsController {
//
//    private final PaymentsProxy paymentsProxy;
//
//    public PaymentsController(PaymentsProxy paymentsProxy) {
//        this.paymentsProxy = paymentsProxy;
//    }
//
//    @PostMapping("/payment") // The app exposes the endpoint with HTTP POST at the path /payment.
//    public Payment createPayment(@RequestBody Payment payment) {
//        String requestId = UUID.randomUUID().toString(); // The method sets a random value for the payment's ID.
//        return paymentsProxy.createPayment(requestId, payment);
//    }
//}
