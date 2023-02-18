package com.senla.server.model.request;

public class WithdrawRequest extends TransactionRequest {
    public WithdrawRequest(RequestType type, String cardNumber, Long amount) {
        super(type, cardNumber, amount);
    }

    public static WithdrawRequest toWithdrawRequest(TransactionRequest request) {
        return new WithdrawRequest(request.getType(), request.getCardNumber(), request.getAmount());
    }
}
