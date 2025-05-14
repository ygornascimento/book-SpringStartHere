package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.PaymentDetails;
import com.example.springstartherepart2.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private PaymentService paymentService;
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    /* In some cases, we need to configure a custom response status. The easiest and most
    common way to customize the HTTP response is using the ResponseEntity class. This class provided by Spring allows you to specify the
    response body, status, and the headers on the HTTP response.*/
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) { /* We get the payment details
    from the HTTP request body. */
        logger.info("Received payment " + paymentDetails.getAmount()); // We log the amount of the payment in the server's console.

        // We send back the payment details object in the HTTP response body, and we set the HTTP response status to 202 ACCEPTED.
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
