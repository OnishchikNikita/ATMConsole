package com.senla.server.model.request;

public class Request {
    private final RequestType type;
    private final String cardNumber;

    public Request(RequestType type, String cardNumber) {
        this.type = type;
        this.cardNumber = cardNumber;
    }

    public RequestType getType() {
        return type;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
