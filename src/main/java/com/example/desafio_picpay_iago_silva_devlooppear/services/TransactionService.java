package com.example.desafio_picpay_iago_silva_devlooppear.services;

import com.example.desafio_picpay_iago_silva_devlooppear.models.Transaction;
import com.example.desafio_picpay_iago_silva_devlooppear.models.User;
import com.example.desafio_picpay_iago_silva_devlooppear.repositories.TransactionRepository;
import com.example.desafio_picpay_iago_silva_devlooppear.repositories.UserRepository; 
import com.example.desafio_picpay_iago_silva_devlooppear.requests.NotificationRequest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private static final String AUTHORIZATION_URL = "https://util.devi.tools/api/v2/authorize";
    private static final String NOTIFICATION_URL = "https://util.devi.tools/api/v1/notify";

    /**
     * Creates a new transaction.
     *
     * @param transaction the transaction to be created
     * @return the created transaction
     * @throws RuntimeException if an error occurs while creating the transaction
     */
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    /**
     * Transfers value from one user to another after authorization.
     *
     * @param value the amount to be transferred
     * @param payer the ID of the user making the payment
     * @param payee the ID of the user receiving the payment
     * @return the created transaction
     * @throws RuntimeException if an error occurs during the transfer
     */
    @Transactional
    public Transaction transfer(double value, Long payerId, Long payeeId) {
        RestTemplate restTemplate = new RestTemplate();
        AuthorizationResponse response = restTemplate.getForObject(AUTHORIZATION_URL, AuthorizationResponse.class);

        if (response != null && response.getData().isAuthorization()) {
            User payer = userRepository.findById(payerId)
                .orElseThrow(() -> new RuntimeException("Payer not found."));
            User payee = userRepository.findById(payeeId)
                .orElseThrow(() -> new RuntimeException("Payee not found."));

            Transaction transaction = new Transaction();
            transaction.setAmount(BigDecimal.valueOf(value));
            transaction.setPayer(payer);
            transaction.setPayee(payee);
            transaction.setTransactionDate(LocalDateTime.now());

            Transaction savedTransaction = transactionRepository.save(transaction);
            sendNotification(payerId, payeeId, value);
            return savedTransaction;
        } else {
            throw new RuntimeException("Transfer not authorized.");
        }
    }

    /**
     * Sends notification to both payer and payee.
     *
     * @param payer the ID of the user making the payment
     * @param payee the ID of the user receiving the payment
     * @param value the amount transferred
     * @throws RuntimeException if an error occurs while sending notifications
     */
    private void sendNotification(Long payer, Long payee, double value) {
        RestTemplate restTemplate = new RestTemplate();
        String message = String.format("You have transferred %.2f to user %d.", value, payee);
        NotificationRequest notificationRequest = new NotificationRequest(message);

        restTemplate.postForEntity(NOTIFICATION_URL, notificationRequest, String.class);
    }

    @Data
    public static class AuthorizationResponse {
        private String status;
        private AuthorizationData data;
    }

    @Data
    public static class AuthorizationData {
        private boolean authorization;
    }
}
