package com.senla.server.controller.request;

public class CardExistRequest extends Request {
    public CardExistRequest(RequestType type, String cardNumber) {
        super(type, cardNumber);
    }
}
