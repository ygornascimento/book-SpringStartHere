package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.execptions.NotEnoughMoneyExecption;
import com.example.springstartherepart2.model.ErrorDetails;
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
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment(); // We try calling the processPayment() method of the service.
            return ResponseEntity.status(HttpStatus.ACCEPTED) /* If calling the service method succeeds, we return an HTTP response
            with status Accepted and the PaymentDetails instance as a response body. */
                    .body(paymentDetails);
        } catch (NotEnoughMoneyExecption e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");
            return ResponseEntity.badRequest().body(errorDetails); /*If an exception of type NotEnoughMoneyException is thrown, we
            return an HTTP response with status Bad Request and an ErrorDetails instance. */
        }
    }
}
