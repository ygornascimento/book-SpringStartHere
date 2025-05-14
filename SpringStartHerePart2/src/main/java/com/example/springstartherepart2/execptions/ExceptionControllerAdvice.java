package com.example.springstartherepart2.execptions;

import com.example.springstartherepart2.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // We use the @RestControllerAdvice annotation to mark the class as a REST controller advice.
public class ExceptionControllerAdvice {
    /* We use the @ExceptionHandler method to associate an exception with the logic the method implements.*/
    @ExceptionHandler(NotEnoughMoneyExecption.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoney() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to make the payment!");
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
