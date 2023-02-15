package com.senla.server.controller.request;

public class TransactionRequest extends Request {
    private final Long amount;

    public TransactionRequest(RequestType type, String cardNumber, Long amount) {
        super(type, cardNumber);
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }


}
