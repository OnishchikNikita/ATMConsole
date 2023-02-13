package com.senla.server.controller.exception;

public class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
