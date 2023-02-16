package com.senla.server.model.request;

public class AuthorizationRequest extends Request {
    private final String pin;

    public AuthorizationRequest(RequestType type, String cardNumber, String pin) {
        super(type, cardNumber);
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }
}
