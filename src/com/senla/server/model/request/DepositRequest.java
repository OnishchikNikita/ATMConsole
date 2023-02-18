package com.senla.server.model.request;

public class DepositRequest extends TransactionRequest {
    public DepositRequest(RequestType type, String cardNumber, Long amount) {
        super(type, cardNumber, amount);
    }

    public static DepositRequest toDepositRequest(TransactionRequest request) {
        return new DepositRequest(request.getType(), request.getCardNumber(), request.getAmount());
    }
}
