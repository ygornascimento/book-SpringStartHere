package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsController {
    private static Logger logger = LoggerFactory
            .getLogger(PaymentsController.class.getName()); /* We use a logger to prove the right controller's method gets
            the correct data when the endpoint is called. */

    @PostMapping("/payment") // The app exposes the endpoint with HTTP POST at the path /payment.
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId, // The endpoint needs to get a request header and the request body from the caller.
            @RequestBody Payment payment) { // The Controller method gets these two details as parameters.

        logger.info("Received request with ID " + requestId +
                " ;Paymount amount: " + payment.getAmount());

        payment.setId(UUID.randomUUID().toString()); // The method sets a random value for the payment's ID.

        return ResponseEntity // The Controller action returns the HTTP response. The response has a header and the response body
                .status(HttpStatus.OK) // that contains the payment with the random ID value set.
                .header("requestId", requestId)
                .body(payment);
    }
}
