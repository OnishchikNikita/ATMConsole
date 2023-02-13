package com.senla.server.controller.request;

public class PinRequest extends Request {
    private final String pin;

    public PinRequest(RequestType requestType, String number, String pin) {
        super(requestType, number);
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }
}
