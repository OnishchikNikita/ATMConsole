package com.senla.server.controller.response;

public class Response {
    private final boolean success;
    private final String content;

    public Response(boolean success, String content) {
        this.success = success;
        this.content = content;
    }

    public Response(boolean success) {
        this.success = success;
        content = null;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getContent() {
        return content;
    }
}
