package com.example.desafio_picpay_iago_silva_devlooppear.controllers;

import com.example.desafio_picpay_iago_silva_devlooppear.requests.TransferRequest;
import com.example.desafio_picpay_iago_silva_devlooppear.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/") 
public class TransferController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest request) {
        try {
            transactionService.transfer(
                request.getAmount().doubleValue(), 
                request.getPayerId(), 
                request.getPayeeId()
            );
            return ResponseEntity.ok("Transaction completed successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Transaction failed: " + e.getMessage());
        }
    }
}
