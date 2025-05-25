package com.example.springstartherechapter12.controller;

import com.example.springstartherechapter12.model.Purchase;
import com.example.springstartherechapter12.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    // We use construction dependency injection to get the repository object from the Spring Context.
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    /* We implement an endpoint a client calls to store a purchase record in the database. We use the repository storePurchase()
    method to persist the data the cotroller's action gets from the HTTP request body. */
    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase){
        purchaseRepository.storePurchase(purchase);
    }

    /* We implement an endpoint the client calls to get all the records from the purchase table. The controller's action
    uses the repository's method to ge the data from the database and returns the data to the client in the HTTP response body.*/
    @GetMapping
    public List<Purchase> listPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}
