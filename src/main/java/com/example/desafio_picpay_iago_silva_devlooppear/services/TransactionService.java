package com.example.desafio_picpay_iago_silva_devlooppear.services;

import com.example.desafio_picpay_iago_silva_devlooppear.models.Transaction;
import com.example.desafio_picpay_iago_silva_devlooppear.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        try {
            return transactionRepository.save(transaction);
        } catch (Exception e) {
            throw new RuntimeException("Error creating transaction: " + e.getMessage());
        }
    }

    public List<Transaction> getAllTransactions() {
        try {
            return transactionRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching transactions: " + e.getMessage());
        }
    }

    public Optional<Transaction> getTransactionById(Long id) {
        try {
            return transactionRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching transaction: " + e.getMessage());
        }
    }

    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        try {
            return transactionRepository.findById(id)
                .map(transaction -> {
                    transaction.setAmount(transactionDetails.getAmount());
                    transaction.setPayer(transactionDetails.getPayer());
                    transaction.setPayee(transactionDetails.getPayee());
                    transaction.setTransactionDate(transactionDetails.getTransactionDate());
                    transaction.setStatus(transactionDetails.getStatus());
                    return transactionRepository.save(transaction);
                }).orElseThrow(() -> new RuntimeException("Transaction not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error updating transaction: " + e.getMessage());
        }
    }

    public void deleteTransaction(Long id) {
        try {
            transactionRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting transaction: " + e.getMessage());
        }
    }
}
