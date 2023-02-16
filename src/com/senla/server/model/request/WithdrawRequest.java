package com.senla.server.model.request;

public class WithdrawRequest extends TransactionRequest {
    public WithdrawRequest(RequestType type, String cardNumber, Long amount) {
        super(type, cardNumber, amount);
    }
}
