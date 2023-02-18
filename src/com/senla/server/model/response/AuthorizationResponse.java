package com.senla.server.model.response;

public class AuthorizationResponse extends Response {
    private final boolean success;
    private String cause;

    public AuthorizationResponse(String message, boolean success) {
        super(message);
        this.success = success;
    }

    public AuthorizationResponse(String message, boolean success, String cause) {
        super(message);
        this.success = success;
        this.cause = cause;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCause() {
        return cause;
    }
}
