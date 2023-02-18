package com.senla.server.controller;

import com.senla.exception.IllegalAmountException;
import com.senla.server.model.request.DepositRequest;
import com.senla.server.model.request.Request;
import com.senla.server.model.response.Response;
import com.senla.server.service.DepositService;

import java.io.IOException;

public class DepositController implements IController {
    public Response execute(Request request) throws IOException {
        DepositRequest depositRequest = (DepositRequest) request;
        try {
            new DepositService().execute(request.getCardNumber(), depositRequest.getAmount());
            return new Response("Your balance successfully changed.");
        } catch (IllegalAmountException exception) {
            return new Response(exception.getMessage());
        }
    }
}
