package com.example.desafio_picpay_iago_silva_devlooppear.requests;

public class NotificationRequest {
    private String message;

    public NotificationRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}