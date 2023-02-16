package com.senla.server.controller;

import com.senla.exception.IllegalAmountException;
import com.senla.server.model.request.DepositRequest;
import com.senla.server.model.request.Request;
import com.senla.server.model.response.Response;
import com.senla.server.service.DepositService;

public class DepositController implements IController {
    public Response execute(Request request) {
        DepositRequest depositRequest = (DepositRequest) request;
        try {
            new DepositService().deposit(request.getCardNumber(), depositRequest.getAmount());
            return new Response("Your balance successfully changed.");
        } catch (IllegalAmountException exception) {
            return new Response(exception.getMessage());
        }
    }
}
