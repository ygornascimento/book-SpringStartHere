package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.PaymentDetails;
import com.example.springstartherepart2.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    /* In some cases, we need to configure a custom response status. The easiest and most
    common way to customize the HTTP response is using the ResponseEntity class. This class provided by Spring allows you to specify the
    response body, status, and the headers on the HTTP response.*/
    public ResponseEntity<PaymentDetails> makePayment() {
        PaymentDetails paymentDetails = paymentService.processPayment();
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
