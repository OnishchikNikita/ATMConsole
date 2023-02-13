package com.senla.server.controller.request;

public class WithdrawRequest extends Request {
    private final long amount;

    public WithdrawRequest(RequestType requestType, String cardNumber, long amount) {
        super(requestType, cardNumber);
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
