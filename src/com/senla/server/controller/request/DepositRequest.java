package com.senla.server.controller.request;

public class DepositRequest extends Request {
    private final long amount;

    public DepositRequest(RequestType requestType, String cardNumber, long amount) {
        super(requestType, cardNumber);
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
