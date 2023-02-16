package com.senla.server.model.request;

public class DepositRequest extends TransactionRequest {
    public DepositRequest(RequestType type, String cardNumber, Long amount) {
        super(type, cardNumber, amount);
    }
}
