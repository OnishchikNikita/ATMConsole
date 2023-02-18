package com.senla.server.controller;

import com.senla.exception.IllegalAmountException;
import com.senla.exception.NotEnoughBalanceException;
import com.senla.server.model.request.Request;
import com.senla.server.model.request.WithdrawRequest;
import com.senla.server.model.response.Response;
import com.senla.server.service.WithdrawService;

import java.io.IOException;

public class WithdrawController implements IController {
    public Response execute(Request request) throws IOException {
        WithdrawRequest withdrawRequest = (WithdrawRequest) request;
        try {
            new WithdrawService().execute(request.getCardNumber(), withdrawRequest.getAmount());
            return new Response("Your balance successfully changed.");
        } catch (IllegalAmountException | NotEnoughBalanceException exception) {
            return new Response(exception.getMessage());
        }
    }
}
