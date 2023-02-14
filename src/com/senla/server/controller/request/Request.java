package com.senla.server.controller.request;

public class Request {
    private final RequestType type;
    private final String cardNumber;
    private final String pin;
    private final Long amount;

    public Request(RequestType type, String cardNumber) {
        this.type = type;
        this.cardNumber = cardNumber;
        pin = null;
        amount = null;
    }

    public Request(RequestType type, String cardNumber, String pin) {
        this.type = type;
        this.cardNumber = cardNumber;
        this.pin = pin;
        amount = null;
    }

    public Request(RequestType type, String cardNumber, Long amount) {
        this.type = type;
        this.cardNumber = cardNumber;
        pin = null;
        this.amount = amount;
    }

    public RequestType getType() {
        return type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public Long getAmount() {
        return amount;
    }
}
