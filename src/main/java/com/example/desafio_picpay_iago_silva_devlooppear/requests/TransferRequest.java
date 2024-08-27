package com.example.desafio_picpay_iago_silva_devlooppear.requests;

import lombok.Data;
import java.math.BigDecimal;

@Data 
public class TransferRequest {
    private Long payerId;
    private Long payeeId;
    private BigDecimal amount;
}
